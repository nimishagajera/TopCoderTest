package com.app.test.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.test.R
import com.app.test.databinding.ActivityMainBinding
import com.app.test.model.State
import com.app.test.ui.main.adapter.DataAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.shreyaspatil.foodium.ui.base.BaseActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private val mAdapter = DataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        // Initialize RecyclerView
        mViewBinding.content.dataRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        initData()
    }

    private fun initData() {
        mViewModel.rowsLiveData.observe(
            this,
            Observer { state ->
                when (state) {
                    is State.Loading -> showLoading(true)
                    is State.Success -> {
                    if (state.data.row?.isNotEmpty()!!) {
                        mViewBinding.toolbarTitle.text = state.data.title
                        mAdapter.submitList(state.data.row)
                        showLoading(false)
                        }
                    }
                    is State.Error -> {
                        val mySnackbar = Snackbar.make(findViewById(R.id.content),
                            R.string.text_no_connectivity, Snackbar.LENGTH_SHORT)
                        mySnackbar.setAction(R.string.text_retry, View.OnClickListener {
                            getRows()
                            showLoading(true)
                        })
                        mySnackbar.show()
                        showLoading(false)
                    }
                }
            }
        )

        mViewBinding.content.swipeRefresh.setOnRefreshListener {
            getRows()
        }

        // If State isn't `Success` then reload data.
        if (mViewModel.rowsLiveData.value !is State.Success) {
            getRows()
        }
    }

    override val mViewModel: MainViewModel by viewModels()

    override fun getViewBinding(): ActivityMainBinding  = ActivityMainBinding.inflate(layoutInflater)

    private fun getRows() {
        mViewModel.getRows()
    }

    private fun showLoading(isLoading: Boolean) {
        mViewBinding.content.swipeRefresh.isRefreshing = isLoading
    }

    override fun onBackPressed() {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.exit_dialog_title))
            .setMessage(resources.getString(R.string.exit_dialog_message))
            .setNegativeButton(resources.getString(R.string.option_no)) { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton(resources.getString(R.string.option_yes)) { dialog, _ ->
                dialog.dismiss()
                super.onBackPressed()
            }
            .show()
    }
}
package com.app.test.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.test.R
import com.app.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarTitle.text = "done";

        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, resources.getText(R.string.error_internet), Snackbar.LENGTH_LONG)
                .setAction(R.string.text_retry, View.OnClickListener {
                    Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
                }).show()
        }*/
    }
}
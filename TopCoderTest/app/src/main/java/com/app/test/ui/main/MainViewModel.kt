
package com.app.test.ui.main

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.app.test.data.repository.DataRepository
import com.app.test.model.DataResponse
import com.app.test.model.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * ViewModel for [MainActivity]
 */
@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    private val _rowsLiveData = MutableLiveData<State<DataResponse>>()

    val rowsLiveData: LiveData<State<DataResponse>>
        get() = _rowsLiveData

    fun getRows() {
        viewModelScope.launch {
            dataRepository.getAllData().collect {
                _rowsLiveData.value = it
            }
        }
    }
}

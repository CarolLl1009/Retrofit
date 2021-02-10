package com.example.retrofit.model.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.MarsRepository
import com.example.retrofit.model.remote.MarsEstate
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {

    private val repository : MarsRepository
    val liveDataFromInternet : LiveData<List<MarsEstate>>

    init {
       repository = MarsRepository()
       viewModelScope.launch {
           repository.fetchMarsData() }
        liveDataFromInternet = repository.dataFromInternet

    }

}
package com.example.retrofit.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.MarsRepository
import com.example.retrofit.model.local.MarsDao
import com.example.retrofit.model.local.MarsDataBase
import com.example.retrofit.model.local.MarsEntity
import com.example.retrofit.model.remote.MarsEstate
import kotlinx.coroutines.launch

class MarsViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository : MarsRepository
    val liveDataFromInternet : LiveData<List<MarsEstate>>
    val allLand : LiveData<List<MarsEntity>>

    init {
       val marsDao = MarsDataBase.getDataBase(application).getMarsDao()
       repository = MarsRepository(marsDao)
       allLand = repository.listAllLand
       viewModelScope.launch {
           repository.fetchMarsData() }
        liveDataFromInternet = repository.dataFromInternet

    }

  }
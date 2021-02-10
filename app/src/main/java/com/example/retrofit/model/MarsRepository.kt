package com.example.retrofit.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.remote.MarsEstate
import com.example.retrofit.model.remote.RetrofitClient
/**
 * Este comentario se ve en la ventanita
 */
class MarsRepository {

    private val retrofitClient = RetrofitClient.getRetrofit()
    val dataFromInternet = MutableLiveData<List<MarsEstate>>()

    suspend fun fetchMarsData() {
        try {
            val response = retrofitClient.fetchMarsData()
            when (response.code()){
                in 200..299 -> dataFromInternet.value = response.body()
                in 300..301 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")

            }

        } catch (t : Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }

}
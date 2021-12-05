package com.example.boilerplateapp2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.boilerplateapp2.ICityRetrofit
import com.example.boilerplateapp2.objects.CityRetrofitClient
import com.example.boilerplateapp2.pojo.City
import retrofit2.Retrofit

class HomeViewModel : ViewModel() {

    fun request_cities() : LiveData<MutableList<City>> {
        val base_url = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/"
        val retrofit_service : Retrofit = CityRetrofitClient.getClient(base_url)
        val my_service = retrofit_service.create(ICityRetrofit::class.java)
        return liveData {
            val data = my_service.getAll()
            data.body()?.let { emit (it)}
        }
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}
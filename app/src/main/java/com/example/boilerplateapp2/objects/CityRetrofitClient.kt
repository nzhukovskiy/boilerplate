package com.example.boilerplateapp2.objects

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CityRetrofitClient {
    private var retrofit : Retrofit? = null
    fun getClient(baseUrl : String) : Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build()
        }
        return retrofit!!
    }
}
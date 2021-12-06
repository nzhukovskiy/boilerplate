package com.example.wearmodule

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ICityRetrofit {
    @GET("City.json")
    fun getAll() : Call<MutableList<City>>
}
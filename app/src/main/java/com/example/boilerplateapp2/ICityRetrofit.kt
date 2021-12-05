package com.example.boilerplateapp2

import com.example.boilerplateapp2.pojo.City
import retrofit2.Response
import retrofit2.http.GET

interface ICityRetrofit {
    @GET("City.json")
    suspend fun getAll() : Response<MutableList<City>>
}
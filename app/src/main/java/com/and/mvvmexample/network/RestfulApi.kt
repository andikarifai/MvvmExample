package com.and.mvvmexample.network

import com.and.mvvmexample.model.ResponseDataUserItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("user")
    fun getAlluser(): Call<List<ResponseDataUserItem>>
}
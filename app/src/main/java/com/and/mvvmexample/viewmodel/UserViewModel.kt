package com.and.mvvmexample.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.and.mvvmexample.model.ResponseDataUserItem
import com.and.mvvmexample.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(
    application: Application
): AndroidViewModel(application) {
    val user = MutableLiveData<List<ResponseDataUserItem>>()

    fun getLiveDataUser():MutableLiveData<List<ResponseDataUserItem>>{
        return user
    }

    fun getAllUser(){
        ApiClient.instance.getAlluser().enqueue(object : Callback<List<ResponseDataUserItem>>{
            override fun onResponse(
                call: Call<List<ResponseDataUserItem>>,
                response: Response<List<ResponseDataUserItem>>
            ) {
                if (response.isSuccessful){
                    user.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                Toast.makeText(getApplication(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
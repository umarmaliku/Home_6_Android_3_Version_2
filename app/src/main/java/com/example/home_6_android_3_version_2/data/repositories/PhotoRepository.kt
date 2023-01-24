package com.example.home_6_android_3_version_2.data.repositories

import com.example.home_6_android_3_version_2.data.models.gets.Photo
import com.example.home_6_android_3_version_2.data.remote.api.PostsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val apiService: PostsApiService) {

    fun getPhoto(
        onSuccess: (photoList: List<Photo>) -> Unit, onFailure: (massage: String) -> Unit
    ) {

        apiService.getPhoto().enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it)
                }
            }
        })
    }
}
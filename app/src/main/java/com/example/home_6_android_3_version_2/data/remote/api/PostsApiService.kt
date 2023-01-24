package com.example.home_6_android_3_version_2.data.remote.api

import com.example.home_6_android_3_version_2.data.models.gets.Photo
import com.example.home_6_android_3_version_2.data.models.posts.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostsApiService {

    @POST("posts")
    fun sentPost(
        @Body post: Post
    ): Call<Post>

    @GET("albums/1/photos")
    fun getPhoto(): Call<List<Photo>>
}
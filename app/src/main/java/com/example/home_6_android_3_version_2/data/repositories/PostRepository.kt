package com.example.home_6_android_3_version_2.data.repositories

import com.example.home_6_android_3_version_2.data.models.posts.Post
import com.example.home_6_android_3_version_2.data.remote.api.PostsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: PostsApiService) {

    fun sentPost(
        onSuccess: (post: Post) -> Unit, onFailure: (massage: String) -> Unit, post: Post
    ) {

        apiService.sentPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                response.body()?.let {
                    onSuccess(it)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it)
                }
            }
        })
    }
}
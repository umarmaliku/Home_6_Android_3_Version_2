package com.example.home_6_android_3_version_2.ui.fragments.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home_6_android_3_version_2.data.models.posts.Post
import com.example.home_6_android_3_version_2.data.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private val _postLiveData = MutableLiveData<Post>()
    val postLiveData: LiveData<Post> = _postLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun sendPost(userid: Int, id: Int, title: String, body: String) {
        repository.sentPost(onSuccess = {
            _postLiveData.value = it
        }, onFailure = {
            _errorLiveData.value = it
        }, post = Post(userid, id, title, body)
        )
    }
}
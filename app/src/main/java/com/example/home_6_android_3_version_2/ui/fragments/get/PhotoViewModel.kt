package com.example.home_6_android_3_version_2.ui.fragments.get

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home_6_android_3_version_2.data.models.gets.Photo
import com.example.home_6_android_3_version_2.data.repositories.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(private val repository: PhotoRepository) : ViewModel() {

    private val _photoLiveData = MutableLiveData<List<Photo>>()
    val photoLiveData: LiveData<List<Photo>> = _photoLiveData

    private val _errorPhotoLiveData = MutableLiveData<String>()
    val errorPhotoLiveData: LiveData<String> = _errorPhotoLiveData

    init {
        getPhoto()
    }

    private fun getPhoto() {
        return repository.getPhoto(onSuccess = {
            _photoLiveData.value = it
        }, onFailure = {
            _errorPhotoLiveData.value = it
        })
    }
}
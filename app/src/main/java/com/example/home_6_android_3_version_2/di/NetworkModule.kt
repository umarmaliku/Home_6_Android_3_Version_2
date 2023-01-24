package com.example.home_6_android_3_version_2.di

import com.example.home_6_android_3_version_2.data.remote.RetrofitClient
import com.example.home_6_android_3_version_2.data.remote.api.PostsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun providePostApiService(): PostsApiService {
        return retrofitClient.postsApiService
    }
}
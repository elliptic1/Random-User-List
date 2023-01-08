package com.tbse.service.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tbse.service.Constants
import com.tbse.service.client.UserServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by toddsmith on 1/7/23.
 */
@Module
@InstallIn(ViewModelComponent::class)
class ServiceModule {

    @Provides
    fun provideUserServiceApi(): UserServiceApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(UserServiceApi::class.java)
    }

}
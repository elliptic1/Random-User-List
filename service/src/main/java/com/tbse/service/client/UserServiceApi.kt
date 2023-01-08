package com.tbse.service.client

import com.tbse.service.models.UserInfoResult
import retrofit2.http.GET

/**
 * Created by toddsmith on 1/7/23.
 */
interface UserServiceApi {

    @GET("?results=40")
    suspend fun getUsers(): UserInfoResult

}
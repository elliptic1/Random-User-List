package com.tbse.domain.repositories

import com.tbse.domain.models.UsersDomain

/**
 * Created by toddsmith on 1/7/23.
 */
interface UsersRepository {
    suspend fun getUsers(): UsersDomain
}
package com.tbse.domain.repositories

import com.tbse.domain.mappers.ModelMapper
import com.tbse.domain.models.UsersDomain
import com.tbse.service.client.UserServiceApi
import com.tbse.service.models.UserInfoResult

class UsersRepositoryImpl(
    private val api: UserServiceApi,
    private val userMapper: ModelMapper<UserInfoResult, UsersDomain>,
) : UsersRepository {
    override suspend fun getUsers(): UsersDomain {
        return userMapper.map(api.getUsers())
    }
}
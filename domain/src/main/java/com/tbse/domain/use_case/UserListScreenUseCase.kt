package com.tbse.domain.use_case

import com.tbse.domain.models.UsersDomain
import com.tbse.domain.repositories.UsersRepository
import com.tbse.service.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by toddsmith on 1/7/23.
 */
class UserListScreenUseCase @Inject constructor(
    private val repo: UsersRepository
) {
    operator fun invoke(): Flow<Resource<out UsersDomain>> = flow {
        try {
            emit(Resource.Loading())
            val users = repo.getUsers()
            emit(Resource.Success(users))
        } catch (e: Exception) {
            emit(Resource.Error(null, "Network error: ${e.stackTrace}"))
        }
    }
}
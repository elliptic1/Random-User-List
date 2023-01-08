package com.tbse.domain.di

import com.tbse.domain.mappers.ModelMapper
import com.tbse.domain.mappers.UserInfoResultModelMapperImpl
import com.tbse.domain.models.UsersDomain
import com.tbse.domain.repositories.UsersRepository
import com.tbse.domain.repositories.UsersRepositoryImpl
import com.tbse.service.client.UserServiceApi
import com.tbse.service.models.UserInfoResult
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by toddsmith on 1/7/23.
 */
@Module(includes = [ModelMapperModule::class])
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUsersRepository(
        api: UserServiceApi,
        userMapper: ModelMapper<UserInfoResult, UsersDomain>,
    ): UsersRepository {
        return UsersRepositoryImpl(api, userMapper)
    }

}
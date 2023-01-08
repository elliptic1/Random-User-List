package com.tbse.domain.mappers

import com.tbse.domain.models.UserInfo as UserInfoDomain
import com.tbse.domain.models.UsersDomain
import com.tbse.service.models.UserInfo as UserInfoService
import com.tbse.service.models.UserInfoResult
import javax.inject.Inject

class UserInfoResultModelMapperImpl @Inject constructor(
    private val userInfoMapper: ModelMapper<UserInfoService?, UserInfoDomain>,
): ModelMapper<UserInfoResult, UsersDomain> {
    override fun map(input: UserInfoResult): UsersDomain {
        return UsersDomain(
            results = input.results?.map(userInfoMapper::map) ?: emptyList()
        )
    }
}
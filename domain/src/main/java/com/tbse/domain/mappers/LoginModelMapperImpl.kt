package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Login as LoginDomain
import com.tbse.service.models.Login as LoginService

class LoginModelMapperImpl @Inject constructor(
) : ModelMapper<LoginService?, LoginDomain> {
    override fun map(input: LoginService?): LoginDomain {
        return LoginDomain(
            md5 = input?.md5 ?: "",
            password = input?.password ?: "",
            salt = input?.salt ?: "",
            sha1 = input?.sha1 ?: "",
            sha256 = input?.sha256 ?: "",
            username = input?.username ?: "",
            uuid = input?.uuid ?: "",
        )
    }
}
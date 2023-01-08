package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Registered as RegisteredDomain
import com.tbse.service.models.Registered as RegisteredService

class RegisteredModelMapperImpl @Inject constructor(
) : ModelMapper<RegisteredService?, RegisteredDomain> {
    override fun map(input: RegisteredService?): RegisteredDomain {
        return RegisteredDomain(
            age = input?.age ?: 0,
            date = input?.date ?: "",
        )
    }
}
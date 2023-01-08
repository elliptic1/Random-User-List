package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Id as IdDomain
import com.tbse.service.models.Id as IdService

class IdModelMapperImpl @Inject constructor(
) : ModelMapper<IdService?, IdDomain> {
    override fun map(input: IdService?): IdDomain {
        return IdDomain(
            name = input?.name ?: "",
            value = input?.value ?: "",
        )
    }
}
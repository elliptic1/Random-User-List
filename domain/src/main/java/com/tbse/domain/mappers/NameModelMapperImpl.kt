package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Name as NameDomain
import com.tbse.service.models.Name as NameService

class NameModelMapperImpl @Inject constructor(
) : ModelMapper<NameService?, NameDomain> {
    override fun map(input: NameService?): NameDomain {
        return NameDomain(
            first = input?.first ?: "",
            last = input?.last ?: "",
            title = input?.title ?: "",
        )
    }
}
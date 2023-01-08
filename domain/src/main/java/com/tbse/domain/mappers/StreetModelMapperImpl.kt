package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Street as StreetDomain
import com.tbse.service.models.Street as StreetService

class StreetModelMapperImpl @Inject constructor(
) : ModelMapper<StreetService?, StreetDomain> {
    override fun map(input: StreetService?): StreetDomain {
        return StreetDomain(
            name = input?.name ?: "",
            number = input?.number ?: 0,
        )
    }
}
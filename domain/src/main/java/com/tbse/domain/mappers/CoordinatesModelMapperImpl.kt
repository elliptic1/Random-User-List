package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Coordinates as CoordinatesDomain
import com.tbse.service.models.Coordinates as CoordinatesService

class CoordinatesModelMapperImpl @Inject constructor(
) : ModelMapper<CoordinatesService?, CoordinatesDomain> {
    override fun map(input: CoordinatesService?): CoordinatesDomain {
        return CoordinatesDomain(
            latitude = input?.latitude ?: "",
            longitude = input?.longitude ?: "",
        )
    }
}
package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Coordinates as CoordinatesDomain
import com.tbse.domain.models.Location as LocationDomain
import com.tbse.domain.models.Street as StreetDomain
import com.tbse.domain.models.Timezone as TimezoneDomain
import com.tbse.service.models.Coordinates as CoordinatesService
import com.tbse.service.models.Location as LocationService
import com.tbse.service.models.Street as StreetService
import com.tbse.service.models.Timezone as TimezoneService

class LocationModelMapperImpl @Inject constructor(
    private val coordinatesMapper: ModelMapper<CoordinatesService?, CoordinatesDomain>,
    private val streetMapper: ModelMapper<StreetService?, StreetDomain>,
    private val timezoneMapper: ModelMapper<TimezoneService?, TimezoneDomain>,
) : ModelMapper<LocationService?, LocationDomain> {
    override fun map(input: LocationService?): LocationDomain {
        return LocationDomain(
            city = input?.city ?: "",
            coordinates = coordinatesMapper.map(input?.coordinates),
            country = input?.country ?: "",
            postcode = input?.postcode ?: "",
            state = input?.state ?: "",
            street = streetMapper.map(input?.street),
            timezone = timezoneMapper.map(input?.timezone),
        )
    }
}
package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Timezone as TimezoneDomain
import com.tbse.service.models.Timezone as TimezoneService

class TimezoneModelMapperImpl @Inject constructor(
) : ModelMapper<TimezoneService?, TimezoneDomain> {
    override fun map(input: TimezoneService?): TimezoneDomain {
        return TimezoneDomain(
            description = input?.description ?: "",
            offset = input?.offset ?: "",
        )
    }
}
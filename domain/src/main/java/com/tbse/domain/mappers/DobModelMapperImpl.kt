package com.tbse.domain.mappers

import java.time.LocalDate
import javax.inject.Inject
import com.tbse.domain.models.Dob as DobDomain
import com.tbse.service.models.Dob as DobService

class DobModelMapperImpl @Inject constructor(
) : ModelMapper<DobService?, DobDomain> {
    override fun map(input: DobService?): DobDomain {
        return DobDomain(
            age = input?.age ?: -1,
            date = input?.date ?: LocalDate.now().toString(),
        )
    }
}
package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Picture as PictureDomain
import com.tbse.service.models.Picture as PictureService

class PictureModelMapperImpl @Inject constructor(
) : ModelMapper<PictureService?, PictureDomain> {
    override fun map(input: PictureService?): PictureDomain {
        return PictureDomain(
            large = input?.large ?: "",
            medium = input?.medium ?: "",
            thumbnail = input?.thumbnail ?: "",
        )
    }
}
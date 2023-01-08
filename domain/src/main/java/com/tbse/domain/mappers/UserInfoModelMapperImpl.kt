package com.tbse.domain.mappers

import javax.inject.Inject
import com.tbse.domain.models.Dob as DobDomain
import com.tbse.domain.models.Id as IdDomain
import com.tbse.domain.models.Location as LocationDomain
import com.tbse.domain.models.Login as LoginDomain
import com.tbse.domain.models.Name as NameDomain
import com.tbse.domain.models.Picture as PictureDomain
import com.tbse.domain.models.Registered as RegisteredDomain
import com.tbse.domain.models.UserInfo as UserInfoDomain
import com.tbse.service.models.Dob as DobService
import com.tbse.service.models.Id as IdService
import com.tbse.service.models.Location as LocationService
import com.tbse.service.models.Login as LoginService
import com.tbse.service.models.Name as NameService
import com.tbse.service.models.Picture as PictureService
import com.tbse.service.models.Registered as RegisteredService
import com.tbse.service.models.UserInfo as UserInfoService

class UserInfoModelMapperImpl @Inject constructor(
    private val dobMapper: ModelMapper<DobService?, DobDomain>,
    private val idMapper: ModelMapper<IdService?, IdDomain>,
    private val locationMapper: ModelMapper<LocationService?, LocationDomain>,
    private val loginMapper: ModelMapper<LoginService?, LoginDomain>,
    private val nameMapper: ModelMapper<NameService?, NameDomain>,
    private val pictureMapper: ModelMapper<PictureService?, PictureDomain>,
    private val registeredMapper: ModelMapper<RegisteredService?, RegisteredDomain>,
) : ModelMapper<UserInfoService, UserInfoDomain> {
    override fun map(input: UserInfoService): UserInfoDomain {
        return UserInfoDomain(
            cell = input.cell ?: "",
            dob = dobMapper.map(input.dob),
            email = input.email ?: "",
            gender = input.gender ?: "",
            id = idMapper.map(input.id),
            location = locationMapper.map(input.location),
            login = loginMapper.map(input.login),
            name = nameMapper.map(input.name),
            nat = input.nat ?: "",
            phone = input.phone ?: "",
            picture = pictureMapper.map(input.picture),
            registered = registeredMapper.map(input.registered),
        )
    }
}
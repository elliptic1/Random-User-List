package com.tbse.domain.di

import com.tbse.domain.mappers.*
import com.tbse.domain.models.UsersDomain
import com.tbse.service.models.UserInfoResult
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.tbse.domain.models.Coordinates as CoordinatesDomain
import com.tbse.domain.models.Dob as DobDomain
import com.tbse.domain.models.Id as IdDomain
import com.tbse.domain.models.Location as LocationDomain
import com.tbse.domain.models.Login as LoginDomain
import com.tbse.domain.models.Name as NameDomain
import com.tbse.domain.models.Picture as PictureDomain
import com.tbse.domain.models.Registered as RegisteredDomain
import com.tbse.domain.models.Street as StreetDomain
import com.tbse.domain.models.Timezone as TimezoneDomain
import com.tbse.domain.models.UserInfo as UserInfoDomain
import com.tbse.service.models.Coordinates as CoordinatesService
import com.tbse.service.models.Dob as DobService
import com.tbse.service.models.Id as IdService
import com.tbse.service.models.Location as LocationService
import com.tbse.service.models.Login as LoginService
import com.tbse.service.models.Name as NameService
import com.tbse.service.models.Picture as PictureService
import com.tbse.service.models.Registered as RegisteredService
import com.tbse.service.models.Street as StreetService
import com.tbse.service.models.Timezone as TimezoneService
import com.tbse.service.models.UserInfo as UserInfoService


/**
 * Created by toddsmith on 1/7/23.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class ModelMapperModule {

    @Binds
    abstract fun bindsUsersModelMapper(
        impl: UserInfoResultModelMapperImpl,
    ): ModelMapper<UserInfoResult, UsersDomain>

    @Binds
    abstract fun userInfoModelMapper(
        impl: UserInfoModelMapperImpl,
    ): ModelMapper<UserInfoService, UserInfoDomain>

    @Binds
    abstract fun dobMapper(
        impl: DobModelMapperImpl,
    ): ModelMapper<DobService?, DobDomain>

    @Binds
    abstract fun idMapper(
        impl: IdModelMapperImpl,
    ): ModelMapper<IdService?, IdDomain>

    @Binds
    abstract fun nameMapper(
        impl: NameModelMapperImpl,
    ): ModelMapper<NameService?, NameDomain>

    @Binds
    abstract fun locationMapper(
        impl: LocationModelMapperImpl,
    ): ModelMapper<LocationService?, LocationDomain>

    @Binds
    abstract fun loginModelMapper(
        impl: LoginModelMapperImpl,
    ): ModelMapper<LoginService?, LoginDomain>

    @Binds
    abstract fun pictureModelMapper(
        impl: PictureModelMapperImpl,
    ): ModelMapper<PictureService?, PictureDomain>

    @Binds
    abstract fun registeredModelMapper(
        impl: RegisteredModelMapperImpl,
    ): ModelMapper<RegisteredService?, RegisteredDomain>

    @Binds
    abstract fun coordinatesModelMapper(
        impl: CoordinatesModelMapperImpl,
    ): ModelMapper<CoordinatesService?, CoordinatesDomain>

    @Binds
    abstract fun streetModelMapper(
        impl: StreetModelMapperImpl,
    ): ModelMapper<StreetService?, StreetDomain>

    @Binds
    abstract fun timezoneModelMapper(
        impl: TimezoneModelMapperImpl,
    ): ModelMapper<TimezoneService?, TimezoneDomain>
}
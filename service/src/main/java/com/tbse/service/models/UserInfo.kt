package com.tbse.service.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInfo(
    val cell: String?,
    val dob: Dob?,
    val email: String?,
    val gender: String?,
    val id: Id?,
    val location: Location?,
    val login: Login?,
    val name: Name?,
    val nat: String?,
    val phone: String?,
    val picture: Picture?,
    val registered: Registered?
)
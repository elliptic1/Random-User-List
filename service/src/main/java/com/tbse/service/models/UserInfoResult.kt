package com.tbse.service.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInfoResult(
    val info: Info?,
    val results: List<UserInfo?>?
)
package com.tbse.service.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Timezone(
    val description: String?,
    val offset: String?
)
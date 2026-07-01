package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResultSet(
    val count: Int,
    val first: String,
    val last: String,
    val played: Int,
)
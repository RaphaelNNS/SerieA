package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Contract(
    val start: String,
    val until: String,
)
package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Squad(
    val id: Long,
    val name: String,
    val position: String,
    val dateOfBirth: String?,
    val nationality: String,
)
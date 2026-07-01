package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable


@Serializable
data class Referee(
    val id: Long,
    val name: String,
    val type: String,
    val nationality: String,
)
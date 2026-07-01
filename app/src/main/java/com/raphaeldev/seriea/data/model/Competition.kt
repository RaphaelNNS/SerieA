package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    val id: Long,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
)
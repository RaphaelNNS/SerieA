package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Coach(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val name: String,
    val dateOfBirth: String,
    val nationality: String,
    val contract: Contract,
)
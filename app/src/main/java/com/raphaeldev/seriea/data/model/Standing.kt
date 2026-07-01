package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Standing(
    val stage: String,
    val type: String,
    val table: List<TableEntry>
)
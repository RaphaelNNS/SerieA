package com.raphaeldev.seriea.data.model.cache

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class CacheRow(
    val key: String? = null,
    val data: JsonElement,
    val fetched_at: String? = null
)
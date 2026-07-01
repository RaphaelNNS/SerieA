package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScorePart(
    val home: Int?,
    val away: Int?,
)
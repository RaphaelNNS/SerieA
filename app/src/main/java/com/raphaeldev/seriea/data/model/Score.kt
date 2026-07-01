package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Score(
    val winner: String? = null,
    val duration: String? = null,
    val fullTime: ScorePart? = null,
    val halfTime: ScorePart? = null,
    val regularTime: ScorePart? = null,
    val extraTime: ScorePart? = null,
    val penalties: ScorePart? = null,
)
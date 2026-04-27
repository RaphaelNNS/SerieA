package com.example.seriea.data.model

data class Score(
    val winner: String?,
    val duration: String,
    val fullTime: ScorePart,
    val halfTime: ScorePart,
    val regularTime: ScorePart?,
    val extraTime: ScorePart?,
    val penalties: ScorePart?,
)
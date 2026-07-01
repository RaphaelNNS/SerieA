package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Match(

    val id: Long,
    val utcDate: String,
    val status: String,
    val stage: String,
    val homeTeam: Team,
    val awayTeam: Team,

    val area: Area? = null,
    val competition: Competition? = null,
    val season: Season? = null,
    val matchday: Int? = null,
    val group: String? = null,
    val lastUpdated: String? = null,
    val score: Score? = null,
    val odds: Odds? = null,

    val referees: List<Referee> = emptyList(),
)
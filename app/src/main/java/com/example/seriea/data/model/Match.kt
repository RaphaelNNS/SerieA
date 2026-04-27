package com.example.seriea.data.model

data class Match(
    val area: Area,
    val competition: Competition,
    val season: Season,
    val id: Long,
    val utcDate: String,
    val status: String,
    val matchday: Int,
    val stage: String,
    val group: String?,
    val lastUpdated: String,
    val homeTeam: Team,
    val awayTeam: Team,
    val score: Score,
    val odds: Odds,
    val referees: List<Referee>,
)
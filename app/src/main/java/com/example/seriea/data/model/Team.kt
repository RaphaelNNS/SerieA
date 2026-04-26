package com.example.seriea.data.model

data class Team(
    val area: Area,
    val id: Long,
    val name: String,
    val shortName: String,
    val tla: String,
    val crest: String,
    val address: String,
    val website: String,
    val founded: Long,
    val clubColors: String,
    val venue: String,
    val runningCompetitions: List<RunningCompetition>,
    val coach: Coach,
    val squad: List<Squad>,
    val lastUpdated: String,
)
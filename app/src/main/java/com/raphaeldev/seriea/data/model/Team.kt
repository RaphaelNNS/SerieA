package com.raphaeldev.seriea.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: Long,
    val name: String,
    val shortName: String,
    val tla: String,
    val crest: String,

    val area: Area? = null,
    val address: String? = null,
    val website: String? = null,
    val founded: Long? = null,
    val clubColors: String? = null,
    val venue: String? = null,
    val runningCompetitions: List<RunningCompetition>? = null,
    val coach: Coach? = null,
    val squad: List<Squad>? = null,
    val lastUpdated: String? = null
)
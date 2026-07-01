package com.raphaeldev.seriea.data.model.Request

import com.raphaeldev.seriea.data.model.Competition
import com.raphaeldev.seriea.data.model.Team
import kotlinx.serialization.Serializable

@Serializable
data class TeamsRequest(
    val count: Long,
    val competition: Competition,
    val teams: List<Team>,
)
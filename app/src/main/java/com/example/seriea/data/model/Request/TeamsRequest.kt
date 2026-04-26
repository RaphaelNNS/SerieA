package com.example.seriea.data.model.Request

import com.example.seriea.data.model.Competition
import com.example.seriea.data.model.Team

data class TeamsRequest(
    val count: Long,
    val competition: Competition,
    val teams: List<Team>,
)
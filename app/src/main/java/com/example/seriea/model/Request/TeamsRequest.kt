package com.example.seriea.model.Request

import com.example.seriea.model.Competition
import com.example.seriea.model.Team

data class TeamsRequest(
    val count: Long,
    val competition: Competition,
    val teams: List<Team>,
)
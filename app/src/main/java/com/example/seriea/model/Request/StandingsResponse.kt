package com.example.seriea.model.Request

import com.example.seriea.model.Competition
import com.example.seriea.model.Season
import com.example.seriea.model.Standing

data class StandingsResponse(
    val competition: Competition,
    val season: Season,
    val standings: List<Standing>
)
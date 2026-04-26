package com.example.seriea.data.model.Request

import com.example.seriea.data.model.Competition
import com.example.seriea.data.model.Season
import com.example.seriea.data.model.Standing

data class StandingsResponse(
    val competition: Competition,
    val season: Season,
    val standings: List<Standing>
)
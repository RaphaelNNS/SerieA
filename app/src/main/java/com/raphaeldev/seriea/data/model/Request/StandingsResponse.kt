package com.raphaeldev.seriea.data.model.Request

import com.raphaeldev.seriea.data.model.Competition
import com.raphaeldev.seriea.data.model.Season
import com.raphaeldev.seriea.data.model.Standing
import kotlinx.serialization.Serializable

@Serializable
data class StandingsResponse(
    val competition: Competition,
    val season: Season,
    val standings: List<Standing>
)
package com.raphaeldev.seriea.data.model.Request

import com.raphaeldev.seriea.data.model.Competition
import com.raphaeldev.seriea.data.model.Match
import com.raphaeldev.seriea.data.model.ResultSet
import kotlinx.serialization.Serializable

@Serializable
data class MatchesResponse(
    val filters: Map<String, String>,
    val resultSet: ResultSet,
    val competition: Competition,
    val matches: List<Match>,
)
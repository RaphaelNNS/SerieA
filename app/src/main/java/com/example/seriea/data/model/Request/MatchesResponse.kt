package com.example.seriea.data.model.Request

import com.example.seriea.data.model.Competition
import com.example.seriea.data.model.Match
import com.example.seriea.data.model.ResultSet

data class MatchesResponse(
    val filters: Map<String, String>,
    val resultSet: ResultSet,
    val competition: Competition,
    val matches: List<Match>,
)
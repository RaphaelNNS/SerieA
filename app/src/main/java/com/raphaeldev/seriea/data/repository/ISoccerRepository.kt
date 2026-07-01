package com.raphaeldev.seriea.data.repository

import com.raphaeldev.seriea.data.model.Match
import com.raphaeldev.seriea.data.model.TableEntry

interface ISoccerRepository {
    suspend fun getBRACompetitionEntries(): List<TableEntry>

    suspend fun getCurrentBRASeason(competitionId: String): Map<String, String>

    suspend fun getBRAMatches(): List<Match>


}

package com.example.seriea.data.repository

import com.example.seriea.data.model.Standing
import com.example.seriea.data.model.TableEntry

interface ISoccerRepository {
    suspend fun getBRACompetitionEntries(): List<TableEntry>

    suspend fun getCurrentBRASeason(competitionId: String): Map<String, String>

}

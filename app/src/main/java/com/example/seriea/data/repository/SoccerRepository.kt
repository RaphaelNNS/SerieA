package com.example.seriea.data.repository

import android.icu.util.TimeUnit
import com.example.seriea.data.model.Request.StandingsResponse
import com.example.seriea.data.model.Standing
import com.example.seriea.data.model.TableEntry
import com.example.seriea.data.network.RetrofitClient
import java.util.Timer

class SoccerRepository(): ISoccerRepository{

    private val api = RetrofitClient.instance
    private var cachedStandingResponse: StandingsResponse? = null
    private val timeLimit = 5 * 60 * 1000L
    private var lastFetchTime = 0L

    private suspend fun getStandingResponse(): StandingsResponse {
        var timeDiference = System.currentTimeMillis() - lastFetchTime
        if(cachedStandingResponse == null || timeDiference > timeLimit){
            cachedStandingResponse = api.getBRAStandings()
            lastFetchTime = System.currentTimeMillis()
        }
        return cachedStandingResponse!!
    }

    override suspend fun getBRACompetitionEntries(): List<TableEntry> {
        return getStandingResponse().standings.first{
            it.type == "TOTAL"
        }.table
    }

    override suspend fun getCurrentBRASeason(competitionId: String): Map<String, String>{
        var comp = getStandingResponse().season
        return mapOf<String, String>(
            "start" to comp.startDate,
            "end" to comp.endDate,
            "currentDay" to comp.currentMatchday.toString()
        )
    }
}
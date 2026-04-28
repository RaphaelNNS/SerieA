package com.example.seriea.data.repository

import com.example.seriea.data.model.Match
import com.example.seriea.data.model.Request.MatchesResponse
import com.example.seriea.data.model.Request.StandingsResponse
import com.example.seriea.data.model.TableEntry
import com.example.seriea.data.network.RetrofitClient

class SoccerRepository(): ISoccerRepository{

    private val api = RetrofitClient.instance
    private var cachedStandingResponse: StandingsResponse? = null
    private var cachedMatchesResponse: MatchesResponse? = null
    private val StandingTimeLimit = 5 * 60 * 1000L
    private val MatchesTimeLimit = 1 * 60 * 1000L
    private var MatchesLastFetchTime = 0L
    private var StandingLastFetchTime = 0L



    private suspend fun getStandingResponse(): StandingsResponse {
        var timeDiference = System.currentTimeMillis() - StandingLastFetchTime
        if(cachedStandingResponse == null || timeDiference > StandingTimeLimit){
            cachedStandingResponse = api.getBRAStandings()
            StandingLastFetchTime = System.currentTimeMillis()
        }
        return cachedStandingResponse!!
    }

    private suspend fun getMatchesResponse(): MatchesResponse {
        var timeDiference = System.currentTimeMillis() - MatchesLastFetchTime
        if(cachedMatchesResponse == null || timeDiference > MatchesTimeLimit){
            cachedMatchesResponse = api.getBRAMatches()
            MatchesLastFetchTime = System.currentTimeMillis()
        }
        return cachedMatchesResponse!!
    }

    override suspend fun getBRAMatches(): List<Match> {
        return getMatchesResponse().matches
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
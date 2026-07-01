package com.raphaeldev.seriea.data.repository

import com.raphaeldev.seriea.data.model.Match
import com.raphaeldev.seriea.data.model.Request.MatchesResponse
import com.raphaeldev.seriea.data.model.Request.StandingsResponse
import com.raphaeldev.seriea.data.model.TableEntry
import com.raphaeldev.seriea.data.model.cache.CacheRow
import com.raphaeldev.seriea.data.network.supabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class SoccerRepository : ISoccerRepository {

    private val json = Json { ignoreUnknownKeys = true }

    private var cachedStandingResponse: StandingsResponse? = null
    private var cachedMatchesResponse: MatchesResponse? = null
    private val standingTimeLimit = 5 * 60 * 1000L
    private val matchesTimeLimit = 1 * 60 * 1000L
    private var matchesLastFetchTime = 0L
    private var standingLastFetchTime = 0L

    private suspend fun fetchFromCache(key: String): CacheRow {
        return supabaseClient
            .from("api_cache")
            .select(Columns.raw("data")) { filter { eq("key", key) } }
            .decodeSingle<CacheRow>()
    }

    private suspend fun getStandingResponse(): StandingsResponse {
        val timeDifference = System.currentTimeMillis() - standingLastFetchTime
        if (cachedStandingResponse == null || timeDifference > standingTimeLimit) {
            val row = fetchFromCache("bra_standings")
            cachedStandingResponse = json.decodeFromJsonElement<StandingsResponse>(row.data)
            standingLastFetchTime = System.currentTimeMillis()
        }
        return cachedStandingResponse!!
    }

    private suspend fun getMatchesResponse(): MatchesResponse {
        val timeDifference = System.currentTimeMillis() - matchesLastFetchTime
        if (cachedMatchesResponse == null || timeDifference > matchesTimeLimit) {
            val row = fetchFromCache("bra_matches")
            cachedMatchesResponse = json.decodeFromJsonElement<MatchesResponse>(row.data)
            matchesLastFetchTime = System.currentTimeMillis()
        }
        return cachedMatchesResponse!!
    }

    override suspend fun getBRAMatches(): List<Match> {
        return getMatchesResponse().matches
    }

    override suspend fun getBRACompetitionEntries(): List<TableEntry> {
        return getStandingResponse().standings.first {
            it.type == "TOTAL"
        }.table
    }

    override suspend fun getCurrentBRASeason(competitionId: String): Map<String, String> {
        val comp = getStandingResponse().season
        return mapOf(
            "start" to comp.startDate,
            "end" to comp.endDate,
            "currentDay" to comp.currentMatchday.toString()
        )
    }
}
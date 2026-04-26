package com.example.seriea.data.network

import com.example.seriea.data.model.Request.StandingsResponse
import com.example.seriea.data.model.Request.TeamsRequest
import retrofit2.http.GET
import retrofit2.http.Path

interface SoccerApiService {
    @GET("teams")
    suspend fun getCompetitions(): TeamsRequest

    @GET("competitions/{area}/teams")
    suspend fun getTeams(@Path("area") area: String): TeamsRequest

    @GET("competitions/2013/standings")
    suspend fun getBRAStandings(
        @Path("code") code: String
    ): StandingsResponse



}
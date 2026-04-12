package com.example.seriea.network

import com.example.seriea.model.Request.TeamsRequest
import retrofit2.http.GET
import retrofit2.http.Path

interface SoccerApiService {
    @GET("teams")
    suspend fun getCompetitions(): TeamsRequest

    @GET("competitions/{area}/teams")
    suspend fun getTeams(@Path("area") area: String): TeamsRequest


}
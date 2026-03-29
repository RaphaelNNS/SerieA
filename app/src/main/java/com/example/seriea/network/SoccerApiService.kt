package com.example.seriea.network

import com.example.seriea.model.Request.TeamsRequest
import retrofit2.http.GET

interface SoccerApiService {
    @GET("teams")
    suspend fun getCompetitions(): TeamsRequest
}
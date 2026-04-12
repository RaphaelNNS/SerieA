package com.example.seriea

import com.example.seriea.network.RetrofitClient
import com.example.seriea.network.SoccerApiService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SoccerApiTest {

    private lateinit var api: SoccerApiService

    @Before
    fun setup() {
        api = RetrofitClient.instance
    }

    @Test
    fun `print team list`(): Unit = runBlocking {
        val response = api.getTeams("BSA")
        response.teams.forEach { team ->
            println(team)
        }
        assert(true)
    }

    @Test
    fun `print area list`(): Unit = runBlocking {
        val response = api.getTeams("BSA")
        response.teams.forEach { team ->
            println(team)
        }
        assert(true)
    }
}
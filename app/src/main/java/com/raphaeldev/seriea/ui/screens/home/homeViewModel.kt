package com.raphaeldev.seriea.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raphaeldev.seriea.data.model.Match
import com.raphaeldev.seriea.data.model.TableEntry
import com.raphaeldev.seriea.data.repository.SoccerRepository
import io.github.jan.supabase.exceptions.RestException
import kotlinx.coroutines.launch
import java.io.IOException

class homeViewModel : ViewModel() {

    private val soccerRepository = SoccerRepository()

    var standingsResponse by mutableStateOf<List<TableEntry>>(emptyList())
        private set
    var matchesList by mutableStateOf<List<Match>>(emptyList())
        private set
    var isLoading by mutableStateOf(true)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    private var loadingCount = 0
        set(value) {
            field = value
            isLoading = value > 0
        }

    init {
        fetchStanding()
        fetchMatches()
    }

    fun fetchStanding() {
        viewModelScope.launch {
            loadingCount++
            try {
                standingsResponse = soccerRepository.getBRACompetitionEntries()
            } catch (e: IOException) {
                error = "Sem conexão"
            } catch (e: RestException) {
                error = "Erro na API: ${e.error}"
            } catch (e: Exception) {
                error = "Erro desconhecido"
            } finally {
                loadingCount--
            }
        }
    }

    fun fetchMatches() {
        viewModelScope.launch {
            loadingCount++
            try {
                matchesList = soccerRepository.getBRAMatches()
            } catch (e: IOException) {
                error = "Sem conexão"
            } catch (e: RestException) {
                error = "Erro na API: ${e.error}"
            } catch (e: Exception) {
                error = "Erro desconhecido"
            } finally {
                loadingCount--
            }
        }
    }
}
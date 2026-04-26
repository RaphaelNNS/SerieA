package com.example.seriea.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seriea.data.model.Standing
import com.example.seriea.data.model.TableEntry
import com.example.seriea.data.repository.SoccerRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class homeViewModel: ViewModel() {

    private val soccerRepository = SoccerRepository()

    var standingsResponse by mutableStateOf<List<TableEntry>>(emptyList())
        private set
    var isLoading by mutableStateOf<Boolean>(true)
        private set
    var error by mutableStateOf<String?>(null)
        private set


    init {
        fetchData()
    }

    fun fetchData(){
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                standingsResponse = soccerRepository.getBRACompetitionEntries()
            } catch (e: IOException) {
                error = "Sem conexão"
            } catch (e: HttpException) {
                error = "Erro na API: ${e.code()}"
            } catch (e: Exception) {
                error = "Erro desconhecido"
            } finally {
                isLoading = false
            }

        }
    }

}
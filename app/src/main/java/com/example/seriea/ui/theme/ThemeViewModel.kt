package com.example.seriea.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue

class ThemeViewModel(
) : ViewModel() {
    var isDarkTheme by mutableStateOf<Boolean?>(null)
        private set

    fun toggleTheme(systemIsDark: Boolean) {
        isDarkTheme = !(isDarkTheme ?: systemIsDark)
    }

    fun init(systemIsDark: Boolean) {
        if (isDarkTheme == null) {
            isDarkTheme = systemIsDark
        }
    }
}
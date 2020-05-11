package com.example.level5_task2.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.level5_task2.database.GameRepository

class MainActivityViewModel (application: Application) : AndroidViewModel(application) {
    private val gameRepository =  GameRepository(application.applicationContext)
    val games = gameRepository.getAllGames()
}
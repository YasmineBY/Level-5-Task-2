package com.example.gamebacklog.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamebacklog.database.GameRepository
import com.example.gamebacklog.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    val listOfGames: LiveData<List<Game>> = gameRepository.getAllGames()


    //todo delete all games function
    fun deleteAllGames() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
//                gameRepository.insertGame(game)
            }
//            success.value = true
        }
    }


}

//    fun insertGame(game: Game) {
//        ioScope.launch {
//            gameRepository.insertGame(game)
//        }
//    }


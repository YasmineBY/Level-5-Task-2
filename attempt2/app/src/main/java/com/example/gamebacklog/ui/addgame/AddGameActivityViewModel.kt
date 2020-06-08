package com.example.gamebacklog.ui.addgame

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.gamebacklog.database.GameRepository
import com.example.gamebacklog.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddGameActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()


    fun insertGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
               gameRepository.insertGame(game)
            }
            success.value = true
        }
    }


}

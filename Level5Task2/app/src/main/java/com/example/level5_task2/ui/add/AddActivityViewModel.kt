package com.example.level5_task2.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.level5_task2.database.GameRepository
import com.example.level5_task2.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AddActivityViewModel (application: Application) : AndroidViewModel(application) {
    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = MutableLiveData<Game?>()
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()


    //Optional create a function to check if the Game object is valid.
    fun addGame() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game.value)
            }
            success.value = true
        }
    }


}
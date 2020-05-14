package com.example.gamebacklog.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamebacklog.database.GameRepository
import com.example.gamebacklog.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    val game = MutableLiveData<Game>()
    val error = MutableLiveData<String>()
    private val gameRepository = GameRepository(application.applicationContext)
    private val ioScope = CoroutineScope(Dispatchers.IO)



    val listOfGames: MutableLiveData<List<Game>> = gameRepository.getAllGames()

    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }




}
//class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val reminderRepository: ReminderRepository = ReminderRepository(application.applicationContext)
//
//    val reminders: LiveData<List<Reminder>> = reminderRepository.getAllReminders()
//
//    private val _count: MutableLiveData<Int> = MutableLiveData(0)
//
//    val count: LiveData<Int>
//        get() = _count
//
//    fun increment() {
//        _count.value = _count.value?.plus(1)
//    }
//
//    private val ioScope = CoroutineScope(Dispatchers.IO)
//
//    fun insertReminder(reminder: Reminder) {
//        ioScope.launch {
//            reminderRepository.insertReminder(reminder)
//        }
//    }
//
//    fun deleteReminder(reminder: Reminder) {
//        ioScope.launch {
//            reminderRepository.deleteReminder(reminder)
//        }
//    }
//}
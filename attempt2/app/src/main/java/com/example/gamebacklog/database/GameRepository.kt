package com.example.gamebacklog.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gamebacklog.model.Game

class GameRepository(context: Context) {

    //todo remove the Context by redoing the Init
    var gameDao:GameDao

//    init {
//        val database = GameRoomDatabase.getDatabase(context)
//        reminderDao = reminderRoomDatabase?.reminderDao()
//    }


    init {
        val database =
            GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }


    fun getAllGames() : LiveData<List<Game>> {
        return gameDao.getAllGames()
    }



//    suspend fun getAllGames(): List<Game> = gameDao.getAllGames()
    suspend fun insertGame(game: Game)= gameDao.insertGame(game)
    suspend fun deleteAllGames()= gameDao.deleteAllGames()

}

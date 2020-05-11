package com.example.gamebacklog.database

import android.content.Context
import com.example.gamebacklog.model.Game

class GameRepository(context: Context) {

    var gameDao:GameDao
    init {
        val database =
            GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }
    suspend fun getAllGames(): List<Game> = gameDao.getAllGames()
    suspend fun insertGame(game: Game)= gameDao.insertGame(game)
}

package com.example.level5_task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.level5_task2.model.Game


class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    //add a new game
    fun insertGame(game: Game?){
        return gameDao.insertGame(game)
    }


    //delete an existing game
    fun deleteGame(game: Game){
        return gameDao.deleteGame(game)
    }


    //delete all games
    fun deleteAllGames(games: List<Game>){
        return gameDao.deleteAllGames(games)
    }

    //retrieve all games
    fun getAllGames(): LiveData<List<Game?>> {
        return gameDao.getAllGames()
    }

}
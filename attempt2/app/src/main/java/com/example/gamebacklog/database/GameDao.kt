package com.example.gamebacklog.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gamebacklog.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM game_table")
     fun getAllGames(): MutableLiveData<List<Game>>

//    @Query("SELECT * FROM game_table")
//    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Query("DELETE FROM game_table")
    suspend fun deleteAllGames()
}
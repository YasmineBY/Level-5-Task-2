package com.example.gamebacklog.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gamebacklog.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM game_table")
    suspend fun getAllGames(): List<Game>
    @Insert
    suspend fun insertGame(game: Game)

}
package com.example.level5_task2.database

import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.level5_task2.model.Game

//You can add games.
//You can remove games by swiping the game to the left.
//You can remove all games at once by clicking the garbage bin in the toolbar.



@Dao
interface GameDao {

    @Insert
    fun insertGame(game: Game)

    @Delete
    fun deleteGame(game: Game)

    //Test this method
    @Delete
    fun deleteAllGames(games: List<Game>)


    @Query("SELECT * FROM game_table ORDER BY releaseDate")
    fun getAllGames(): LiveData<List<Game?>>

}
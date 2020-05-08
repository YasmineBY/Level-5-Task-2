package com.example.level5_task2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.level5_task2.model.Game


//You can add games.
//You can remove games by swiping the game to the left.
//You can remove all games at once by clicking the garbage bin in the toolbar.



@Dao
interface GameDao {

    @Query("SELECT * FROM Game LIMIT 1")
    fun getGames(): LiveData<Game?>




}
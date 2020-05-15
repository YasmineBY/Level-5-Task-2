package com.example.gamebacklog.ui.addgame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklog.R
import com.example.gamebacklog.database.GameRepository
import com.example.gamebacklog.model.Game
import com.example.gamebacklog.ui.main.GameAdapter
import com.example.gamebacklog.ui.main.MainActivity

import kotlinx.android.synthetic.main.activity_add_game.*
import kotlinx.android.synthetic.main.content_add_game.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class AddGameActivity : AppCompatActivity() {
    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)

    private val viewModel: AddGameActivityViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)
        setSupportActionBar(toolbar)

        initViews()
    }


    private fun initViews() {
        fab.setOnClickListener { view ->
            retrieveNewGame()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            insertGame()
        }

    }

    fun insertGame() {
        var newGame = retrieveNewGame()
        viewModel.insertGame(newGame)
    }

    fun retrieveNewGame():Game   {
        var newGameTitle = etGameTitle.text.toString()
        var newGamePlatform =  etPlatform.text.toString()
//        var newGameDate: String = etYear.text.toString() + "-" + etMonth.text.toString()+ "-" + etDay.text.toString()
//        var newGame = Game(newGameTitle,newGamePlatform, newGameDate)
        var newDate: Date = Date(2020-1-1)
        var newGame = Game(newGameTitle,newGamePlatform, newDate)


        return newGame

    }

    private fun addGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game)
            }
        }
    }


//    fun getMonthOfDate(receivedMonth: String): String {
//        var month: String =""
//        when(receivedMonth){
//            "1" -> month = "January"
//            "2" -> month = "February"
//            "3" -> month = "March"
//            "4" -> month = "April"
//            "5" -> month = "May"
//            "6" -> month = "June"
//            "7" -> month = "July"
//            "8" -> month = "August"
//            "9" -> month = "September"
//            "10" -> month = "October"
//            "11" -> month = "November"
//            "12" -> month = "December"
//        }
//        return month
//    }


}

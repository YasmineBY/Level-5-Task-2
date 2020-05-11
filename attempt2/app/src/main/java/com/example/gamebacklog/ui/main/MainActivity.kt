package com.example.gamebacklog.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import com.example.gamebacklog.database.GameRepository
import com.example.gamebacklog.model.Game
import com.example.gamebacklog.ui.addgame.AddGameActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        gameRepository = GameRepository(this)
        initViews()

    }

    private fun initViews() {
        rvGames.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter
        rvGames.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        gameAdapter.notifyDataSetChanged()
        updateUI()

        fab.setOnClickListener { view ->
            val intent = Intent(this, AddGameActivity::class.java)
            startActivity(intent)

        }
    }

    private fun addGames(newGame: Game) {

        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insertGame(newGame)
            }
        }
    }


    private fun updateUI() {
        mainScope.launch {
            val gameList = withContext(Dispatchers.IO) {
                gameRepository.getAllGames()
            }
            this@MainActivity.games.clear()
            this@MainActivity.games.addAll(gameList)
            this@MainActivity.gameAdapter.notifyDataSetChanged()
        }
    }

    private fun deleteAllGames() {
        mainScope.launch {
            val gameList = withContext(Dispatchers.IO) {
                gameRepository.deleteAllGames()
            }
            this@MainActivity.games.clear()
            this@MainActivity.gameAdapter.notifyDataSetChanged()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.actioin_delete_games -> {
                deleteAllGames()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

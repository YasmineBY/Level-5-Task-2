package com.example.gamebacklog.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
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
//    private val mainScope = CoroutineScope(Dispatchers.Main)
//    private val games = arrayListOf<Game>()
//    private val gameAdapter = GameAdapter(games)
//    private lateinit var recyclerView: RecyclerView

//    private lateinit var games: ArrayList<Game>
//    private lateinit var gameRepository: GameRepository
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var viewManager: RecyclerView.LayoutManager
//    private val gameAdapter = GameAdapter(games)
//    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var games: ArrayList<Game>
    private lateinit var recyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
//        gameRepository = GameRepository(this)
//        initViews()

        recyclerView = findViewById(R.id.rvGames)
        games = arrayListOf()
        gameAdapter = GameAdapter(games)
        viewManager = LinearLayoutManager(this)
        createItemTouchHelper().attachToRecyclerView(recyclerView)

        observeViewModel()

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = gameAdapter
        }
        fab.setOnClickListener { view ->
            val intent = Intent(this, AddGameActivity::class.java)
            startActivity(intent)

        }
    }


    private fun observeViewModel() {
    viewModel.listOfGames.observe(this, Observer {
         games ->
        this@MainActivity.games.clear()
        this@MainActivity.games.addAll(games)
        gameAdapter.notifyDataSetChanged()
    })
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
//                deleteAllGames()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createItemTouchHelper(): ItemTouchHelper {

        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val gameToDelete = games[position]

//              todo delete game action
            }
        }
        return ItemTouchHelper(callback)
    }


}
//    private fun initViews() {
//        rvGames.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
//        rvGames.adapter = gameAdapter
//        rvGames.addItemDecoration(
//            DividerItemDecoration(
//                this@MainActivity,
//                DividerItemDecoration.VERTICAL
//            )
//        )
//        gameAdapter.notifyDataSetChanged()
////        updateUI()
//

//    }

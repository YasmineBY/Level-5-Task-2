package com.example.level5_task2.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.level5_task2.R
import com.example.level5_task2.database.GameDao
import com.example.level5_task2.database.GameRoomDatabase
import com.example.level5_task2.model.Game
import com.example.level5_task2.ui.add.AddActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.game_item.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        initViews()
        initViewModel()
    }



    private fun initViews() {
        fab.setOnClickListener { view ->
            val intent = Intent(this, AddActivity::class.java)
//            intent.putExtra(AddActivity.EXTRA_NOTE, mainActivityViewModel.note.value)
            startActivity(intent)
        }
    }

//    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//    .setAction("Action", null).show()

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.games.observe(this, Observer { games ->
            if (games != null) {
                for(game in games){
                    txtGameName.text = game?.title
                    txtPlatform.text = game?.platform
                    txtDate.text = game?.releaseDate
                }
            }
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
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

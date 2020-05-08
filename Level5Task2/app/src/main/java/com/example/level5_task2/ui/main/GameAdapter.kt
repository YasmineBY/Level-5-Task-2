package com.example.level5_task2.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.level5_task2.R
import com.example.level5_task2.model.Game


class GameAdapter (private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        )
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(games[position])
    }


}


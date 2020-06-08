package com.example.gamebacklog.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat
import java.util.*


class GameAdapter (private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    fun formatDate(receivedDate: Date): String {
        var formatDate: SimpleDateFormat? = SimpleDateFormat("MMM d yyyy ")
        var formattedDate = formatDate?.format(receivedDate)
        return  "Release: " +  formattedDate.toString()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            itemView.txtGameName.text = game.title
            itemView.txtPlatform.text = game.platform
            itemView.txtDate.text = formatDate(game.releaseDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }


}


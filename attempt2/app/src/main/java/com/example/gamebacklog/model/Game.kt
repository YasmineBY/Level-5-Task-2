package com.example.gamebacklog.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "game_table")
data class Game (
    var title: String,
    var platform: String,
    var releaseDate: String,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
) : Parcelable
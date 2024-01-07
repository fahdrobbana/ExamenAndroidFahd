package tn.esprit.examenandroidfahd.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(true)
    val id: Int,

    val imageRes: Int,

    val title: String,

    val description: String,

    )

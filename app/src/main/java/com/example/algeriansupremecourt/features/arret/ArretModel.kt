package com.example.algeriansupremecourt.features.arret

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "arrets")
class ArretModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,

    @ColumnInfo(name = "NumArret")
    val numArret: String,

    @ColumnInfo(name = "ChambreArret")
    val chambreArret: String,

    @ColumnInfo(name = "RefArret")
    val refArret: String,

    @ColumnInfo(name = "AnneeRef")
    val anneeRef: String,

    @ColumnInfo(name = "numRef")
    val numRef: String,

    @ColumnInfo(name = "numPageRef")
    val numPageRef: String,

    @ColumnInfo(name = "DateArret")
    val dateArret: String,

    @ColumnInfo(name = "PartiesArret")
    val partiesArret: String,

    @ColumnInfo(name = "PrincipeArret")
    val principeArret: String,

    @ColumnInfo(name = "DecisionArret")
    val decisionArret: String,

    @ColumnInfo(name = "DecisionOpArret")
    val decisionOpArret: String,

    @ColumnInfo(name = "CompositionArret")
    val compositionArret: String,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean = false
)
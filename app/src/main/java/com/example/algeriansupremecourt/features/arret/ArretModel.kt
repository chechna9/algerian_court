package com.example.algeriansupremecourt.features.arret

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

@Entity(tableName = "arrets")
class ArretModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,

    @ColumnInfo(name = "NumArret")
    @SerializedName("NumArret")
    val numArret: String,

    @ColumnInfo(name = "ChambreArret")
    @SerializedName( "ChambreArret")
    val chambreArret: String,

    @ColumnInfo(name = "RefArret")
    @SerializedName( "RefArret")
    val refArret: String,

    @ColumnInfo(name = "AnneeRef")
    @SerializedName( "AnneeRef")
    val anneeRef: String,

    @ColumnInfo(name = "numRef")
    @SerializedName("numRef")
    val numRef: String,

    @ColumnInfo(name = "numPageRef")
    @SerializedName( "numPageRef")
    val numPageRef: String,

    @ColumnInfo(name = "DateArret")
    @SerializedName( "DateArret")
    val dateArret: String,

    @ColumnInfo(name = "PartiesArret")
    @SerializedName( "PartiesArret")
    val partiesArret: String,

    @ColumnInfo(name = "PrincipeArret")
    @SerializedName("PrincipeArret")
    val principeArret: String,

    @ColumnInfo(name = "DecisionArret")
    @SerializedName( "DecisionArret")
    val decisionArret: String,

    @ColumnInfo(name = "DecisionOpArret")
    @SerializedName("DecisionOpArret")
    val decisionOpArret: String,

    @ColumnInfo(name = "CompositionArret")
    @SerializedName( "CompositionArret")
    val compositionArret: String,

    @ColumnInfo(name = "isFavorite")
    @SerializedName( "isFavorite")
    val isFavorite: Boolean = false
)
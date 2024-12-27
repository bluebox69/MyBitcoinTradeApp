package com.example.mybitcointradeapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "investments")
data class InvestmentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
    val currentPrice: Double // optional für Caching
)

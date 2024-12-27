package com.example.mybitcointradeapp.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "portfolio",
    foreignKeys = [ForeignKey(
        entity = InvestmentEntity::class,
        parentColumns = ["id"],
        childColumns = ["investmentId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PortfolioEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val investmentId: String,
    val quantity: Double,
    val averagePrice: Double
)

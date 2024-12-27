package com.example.mybitcointradeapp.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "transactions",
    foreignKeys = [ForeignKey(
        entity = InvestmentEntity::class,
        parentColumns = ["id"],
        childColumns = ["investmentId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val investmentId: String,
    val type: String, // "buy" or "sell"
    val quantity: Double,
    val price: Double,
    val date: Long
)
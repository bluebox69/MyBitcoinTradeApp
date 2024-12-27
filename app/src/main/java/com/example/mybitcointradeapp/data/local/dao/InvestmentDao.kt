package com.example.mybitcointradeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mybitcointradeapp.data.local.entities.InvestmentEntity


@Dao
interface InvestmentDao {
    @Query("SELECT * FROM investments")
    suspend fun getAllInvestments(): List<InvestmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvestments(investments: List<InvestmentEntity>)
}
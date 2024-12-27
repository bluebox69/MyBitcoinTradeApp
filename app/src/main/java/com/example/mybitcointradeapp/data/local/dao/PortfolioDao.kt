package com.example.mybitcointradeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mybitcointradeapp.data.local.entities.PortfolioEntity

@Dao
interface PortfolioDao {
    @Query("SELECT * FROM portfolio")
    suspend fun getPortfolio(): List<PortfolioEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPortfolio(portfolio: PortfolioEntity)

    @Query("DELETE FROM portfolio")
    suspend fun clearPortfolio()
}
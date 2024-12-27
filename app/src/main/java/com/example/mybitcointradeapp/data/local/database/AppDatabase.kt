package com.example.mybitcointradeapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mybitcointradeapp.data.local.dao.InvestmentDao
import com.example.mybitcointradeapp.data.local.dao.PortfolioDao
import com.example.mybitcointradeapp.data.local.dao.TransactionDao
import com.example.mybitcointradeapp.data.local.entities.InvestmentEntity
import com.example.mybitcointradeapp.data.local.entities.PortfolioEntity
import com.example.mybitcointradeapp.data.local.entities.TransactionEntity

@Database(
    entities = [InvestmentEntity::class, PortfolioEntity::class, TransactionEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun investmentDao(): InvestmentDao
    abstract fun portfolioDao(): PortfolioDao
    abstract fun transactionDao(): TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
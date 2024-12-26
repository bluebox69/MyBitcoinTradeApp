package com.example.mybitcointradeapp.domain.repository

import com.example.mybitcointradeapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDto
}
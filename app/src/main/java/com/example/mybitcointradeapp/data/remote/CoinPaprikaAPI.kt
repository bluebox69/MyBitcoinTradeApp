package com.example.mybitcointradeapp.data.remote

import com.example.mybitcointradeapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/tickers")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/tickers/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDto

}
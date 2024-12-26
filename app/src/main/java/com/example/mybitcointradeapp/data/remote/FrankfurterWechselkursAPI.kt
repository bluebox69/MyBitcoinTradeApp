package com.example.mybitcointradeapp.data.remote

import com.example.mybitcointradeapp.domain.model.UsdToEurRate
import retrofit2.http.GET

interface FrankfurterExchangeAPI {

    @GET("/v1/latest?base=USD")
    suspend fun getUsdToEurRate(): UsdToEurRate
}
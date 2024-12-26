package com.example.mybitcointradeapp.data.remote

import com.example.mybitcointradeapp.data.remote.dto.UsdToEurDto
import retrofit2.http.GET

interface FrankfurterExchangeAPI {

    @GET("/v1/latest?base=USD")
    suspend fun getUsdToEurRate(): UsdToEurDto
}
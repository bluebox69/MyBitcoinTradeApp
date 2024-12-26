package com.example.mybitcointradeapp.domain.repository

import com.example.mybitcointradeapp.domain.model.UsdToEurRate

interface UsdToEeuRateRepository {
    suspend fun getUsdToEurRate(): UsdToEurRate

}
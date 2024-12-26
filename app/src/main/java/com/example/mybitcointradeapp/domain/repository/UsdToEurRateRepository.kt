package com.example.mybitcointradeapp.domain.repository

import com.example.mybitcointradeapp.data.remote.dto.UsdToEurDto

interface UsdToEurRateRepository {
    suspend fun getUsdToEurRate(): UsdToEurDto

}
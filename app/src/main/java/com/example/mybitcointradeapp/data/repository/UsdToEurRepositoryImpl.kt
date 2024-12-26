package com.example.mybitcointradeapp.data.repository

import com.example.mybitcointradeapp.data.remote.FrankfurterExchangeAPI
import com.example.mybitcointradeapp.domain.model.UsdToEurRate
import com.example.mybitcointradeapp.domain.repository.UsdToEeuRateRepository
import javax.inject.Inject

class UsdToEurRepositoryImpl @Inject constructor(
    private val api: FrankfurterExchangeAPI
) : UsdToEeuRateRepository  {
    override suspend fun getUsdToEurRate(): UsdToEurRate {
        return api.getUsdToEurRate()
    }
}
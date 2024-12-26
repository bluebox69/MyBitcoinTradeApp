package com.example.mybitcointradeapp.data.repository

import com.example.mybitcointradeapp.data.remote.FrankfurterExchangeAPI
import com.example.mybitcointradeapp.domain.model.UsdToEurRate
import com.example.mybitcointradeapp.domain.repository.UsdToEurRateRepository
import javax.inject.Inject

class UsdToEurRepositoryImpl @Inject constructor(
    private val api: FrankfurterExchangeAPI
) : UsdToEurRateRepository  {
    override suspend fun getUsdToEurRate(): UsdToEurRate {
        return api.getUsdToEurRate()
    }
}
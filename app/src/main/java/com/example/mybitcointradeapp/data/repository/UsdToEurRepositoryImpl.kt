package com.example.mybitcointradeapp.data.repository

import com.example.mybitcointradeapp.data.remote.FrankfurterExchangeAPI
import com.example.mybitcointradeapp.data.remote.dto.UsdToEurDto
import com.example.mybitcointradeapp.domain.repository.UsdToEurRateRepository
import javax.inject.Inject

class UsdToEurRepositoryImpl @Inject constructor(
    private val api: FrankfurterExchangeAPI
) : UsdToEurRateRepository  {
    override suspend fun getUsdToEurRate(): UsdToEurDto {
        return api.getUsdToEurRate()
    }
}
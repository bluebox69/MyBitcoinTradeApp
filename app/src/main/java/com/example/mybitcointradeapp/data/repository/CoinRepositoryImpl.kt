package com.example.mybitcointradeapp.data.repository
import com.example.mybitcointradeapp.data.remote.CoinPaprikaAPI
import com.example.mybitcointradeapp.data.remote.dto.CoinDto
import com.example.mybitcointradeapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDto {
        return api.getCoinById(coinId)
    }
}
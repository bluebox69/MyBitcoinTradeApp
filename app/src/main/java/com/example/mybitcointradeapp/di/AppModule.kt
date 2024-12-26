package com.example.mybitcointradeapp.di

import com.example.mybitcointradeapp.common.Constant
import com.example.mybitcointradeapp.data.remote.CoinPaprikaAPI
import com.example.mybitcointradeapp.data.remote.FrankfurterExchangeAPI
import com.example.mybitcointradeapp.data.repository.CoinRepositoryImpl
import com.example.mybitcointradeapp.data.repository.UsdToEurRepositoryImpl
import com.example.mybitcointradeapp.domain.repository.CoinRepository
import com.example.mybitcointradeapp.domain.repository.UsdToEurRateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) // all the dependencies in de Module lives as long as the Application does
object AppModule {

    @Provides
    @Singleton //makes sure there is a single instance
    fun providePaprikaApi(): CoinPaprikaAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL_COIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUsdToEurRateApi(): FrankfurterExchangeAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL_USD)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FrankfurterExchangeAPI::class.java)

    }

    @Provides
    @Singleton
    fun provideUsdToEurRateRepository(api: FrankfurterExchangeAPI): UsdToEurRateRepository {
        return UsdToEurRepositoryImpl(api)
    }


}
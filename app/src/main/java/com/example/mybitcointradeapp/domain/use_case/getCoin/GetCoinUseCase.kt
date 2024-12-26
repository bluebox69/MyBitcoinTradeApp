package com.example.mybitcointradeapp.domain.use_case.getCoin

import com.example.mybitcointradeapp.common.Resource
import com.example.mybitcointradeapp.data.remote.dto.toCoin
import com.example.mybitcointradeapp.domain.model.Coin
import com.example.mybitcointradeapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    //With Resource we can emit Success , Error oder Loading
   operator fun invoke(coinId: String): Flow<Resource<Coin>> = flow {
       try {
           emit(Resource.Loading())
           val coin =  repository.getCoinById(coinId).toCoin()
           emit(Resource.Success(coin))

       } catch (e: HttpException) {
           emit(Resource.Error(e.localizedMessage ?: "An unexpected Error occurred"))

       } catch (e: IOException) { // If the API cant talk to the remote API or we have no Internet connection
            emit(Resource.Error("Check you internet connection!"))
       }
    }
}
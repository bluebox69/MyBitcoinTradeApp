package com.example.mybitcointradeapp.domain.use_case.getUsdToEurRate

import com.example.mybitcointradeapp.common.Resource
import com.example.mybitcointradeapp.data.remote.dto.toEurRate
import com.example.mybitcointradeapp.domain.model.UsdToEurRate
import com.example.mybitcointradeapp.domain.repository.UsdToEurRateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsdToEurRateUseCase @Inject constructor(
    private val repository: UsdToEurRateRepository
) {
    //With Resource we can emit Success , Error oder Loading
   operator fun invoke(): Flow<Resource<UsdToEurRate>> = flow {
       try {
           emit(Resource.Loading())
           val usdToEurDto = repository.getUsdToEurRate()
           val eurRate = usdToEurDto.toEurRate()
           emit(Resource.Success(eurRate))

       } catch (e: HttpException) {
           emit(Resource.Error(e.localizedMessage ?: "An unexpected Error occurred"))

       } catch (e: IOException) { // If the API cant talk to the remote API or we have no Internet connection
            emit(Resource.Error("Check you internet connection!"))
       }
    }
}
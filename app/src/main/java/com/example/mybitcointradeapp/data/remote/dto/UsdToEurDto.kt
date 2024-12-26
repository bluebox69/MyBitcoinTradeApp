package com.example.mybitcointradeapp.data.remote.dto

import com.example.mybitcointradeapp.domain.model.UsdToEurRate

data class UsdToEurDto(
    val amount: Int,
    val base: String,
    val date: String,
    val rates: Rates
)

data class Rates(
    val AUD: Double,
    val BGN: Double,
    val BRL: Double,
    val CAD: Double,
    val CHF: Double,
    val CNY: Double,
    val CZK: Double,
    val DKK: Double,
    val EUR: Double,
    val GBP: Double,
    val HKD: Double,
    val HUF: Double,
    val IDR: Int,
    val ILS: Double,
    val INR: Double,
    val ISK: Double,
    val JPY: Double,
    val KRW: Double,
    val MXN: Double,
    val MYR: Double,
    val NOK: Double,
    val NZD: Double,
    val PHP: Double,
    val PLN: Double,
    val RON: Double,
    val SEK: Double,
    val SGD: Double,
    val THB: Double,
    val TRY: Double,
    val ZAR: Double
)

fun UsdToEurDto.toEurRate(): UsdToEurRate {
    return UsdToEurRate(
        rates = com.example.mybitcointradeapp.domain.model.Rates(
            eur = this.rates.EUR
        )
    )
}


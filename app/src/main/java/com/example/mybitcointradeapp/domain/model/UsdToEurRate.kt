package com.example.mybitcointradeapp.domain.model

import com.google.gson.annotations.SerializedName


data class UsdToEurRate(
    @SerializedName("rates")
    val rates: Rates
)

data class Rates(
    @SerializedName("EUR")
    val eur: Double
)

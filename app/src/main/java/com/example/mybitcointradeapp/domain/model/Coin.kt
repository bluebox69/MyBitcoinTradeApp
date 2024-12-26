package com.example.mybitcointradeapp.domain.model


data class Coin(
    val id: String,
    val name: String,
    val symbol: String,

    val price: Double,
)

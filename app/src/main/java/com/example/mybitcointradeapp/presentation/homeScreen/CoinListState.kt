package com.example.mybitcointradeapp.presentation.homeScreen

import com.example.mybitcointradeapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

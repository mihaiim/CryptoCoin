package com.mihaiim.cryptocoin.presentation.coin_list

import com.mihaiim.cryptocoin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

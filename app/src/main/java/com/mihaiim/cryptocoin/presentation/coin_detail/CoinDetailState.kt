package com.mihaiim.cryptocoin.presentation.coin_detail

import com.mihaiim.cryptocoin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

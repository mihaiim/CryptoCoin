package com.mihaiim.cryptocoin.domain.repository

import com.mihaiim.cryptocoin.common.Resource
import com.mihaiim.cryptocoin.domain.model.Coin
import com.mihaiim.cryptocoin.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): Resource<List<Coin>>

    suspend fun getCoinById(coinId: String): Resource<CoinDetail>
}
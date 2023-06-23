package com.mihaiim.cryptocoin.data.repository

import com.mihaiim.cryptocoin.common.Resource
import com.mihaiim.cryptocoin.data.remote.CoinPaprikaApi
import com.mihaiim.cryptocoin.data.remote.dto.toCoin
import com.mihaiim.cryptocoin.data.remote.dto.toCoinDetail
import com.mihaiim.cryptocoin.domain.model.Coin
import com.mihaiim.cryptocoin.domain.model.CoinDetail
import com.mihaiim.cryptocoin.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            val coins = api.getCoins().map { it.toCoin() }
            Resource.Success<List<Coin>>(coins)
        } catch (e: HttpException) {
            Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection")
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return try {
            val coinDetail = api.getCoinById(coinId).toCoinDetail()
            Resource.Success<CoinDetail>(coinDetail)
        } catch (e: HttpException) {
            Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection")
        }
    }
}
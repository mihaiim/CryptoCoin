package com.mihaiim.cryptocoin.domain.use_case.get_coins

import com.mihaiim.cryptocoin.common.Resource
import com.mihaiim.cryptocoin.domain.model.Coin
import com.mihaiim.cryptocoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading<List<Coin>>())
        emit(repository.getCoins())
    }
}
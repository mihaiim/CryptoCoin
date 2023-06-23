package com.mihaiim.cryptocoin.domain.use_case.get_coin

import com.mihaiim.cryptocoin.common.Resource
import com.mihaiim.cryptocoin.domain.model.CoinDetail
import com.mihaiim.cryptocoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading<CoinDetail>())
        emit(repository.getCoinById(coinId))
    }
}
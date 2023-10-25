package com.valorantproject.core.data.repository

import com.valorantproject.core.common.Resource
import com.valorantproject.core.network.ApiService
import com.valorantproject.core.network.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : AgentRepository {
    override fun getAgentList(): Flow<Resource<List<Data>>> = flow {
        try {
            val response = apiService.getAgentsList()

            if (response.code() == 200 || response.body()?.data != null) {
                val result = response.body()?.data?.mapNotNull { it }

                emit(Resource.Success(result))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (exc: IOException) {
            emit(Resource.Error(exc.message))
        } catch (exc: Exception) {
            emit(Resource.Error(exc.message))
        }
    }.flowOn(Dispatchers.IO)
}
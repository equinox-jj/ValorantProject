package com.valorantproject.core.data.repository

import com.valorantproject.core.common.Resource
import com.valorantproject.core.network.model.Data
import kotlinx.coroutines.flow.Flow

interface AgentRepository {
    fun getAgentList(): Flow<Resource<List<Data>>>
}
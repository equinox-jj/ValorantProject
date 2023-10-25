package com.valorantproject.core.network

import com.valorantproject.core.network.model.AgentsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("agents")
    suspend fun getAgentsList(
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true,
    ): Response<AgentsList>

}
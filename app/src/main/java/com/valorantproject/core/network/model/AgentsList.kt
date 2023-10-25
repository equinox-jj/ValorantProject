package com.valorantproject.core.network.model


import com.google.gson.annotations.SerializedName

data class AgentsList(
    @SerializedName("data") val `data`: List<Data?> = listOf(),
    @SerializedName("status") val status: Int? = 0
)
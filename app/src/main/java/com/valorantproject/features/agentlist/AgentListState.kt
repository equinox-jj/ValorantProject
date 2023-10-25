package com.valorantproject.features.agentlist

import androidx.compose.runtime.Immutable
import com.valorantproject.core.network.model.Data

@Immutable
data class AgentListState(
    val isLoading: Boolean = false,
    val agentList: List<Data>? = emptyList(),
    val isError: String? = null,
)

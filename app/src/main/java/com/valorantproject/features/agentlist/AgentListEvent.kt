package com.valorantproject.features.agentlist

sealed interface AgentListEvent {
    data object OnAgentListFetched : AgentListEvent
}
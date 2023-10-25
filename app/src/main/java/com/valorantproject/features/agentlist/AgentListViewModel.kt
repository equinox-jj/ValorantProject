package com.valorantproject.features.agentlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valorantproject.core.common.Resource
import com.valorantproject.core.data.repository.AgentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val agentRepository: AgentRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(AgentListState())
    val state = _state.asStateFlow()

    init {
        onEvent(AgentListEvent.OnAgentListFetched)
    }

    fun onEvent(event: AgentListEvent) {
        when(event) {
            AgentListEvent.OnAgentListFetched -> getAgentList()
        }
    }

    private fun getAgentList() {
        viewModelScope.launch(Dispatchers.Main) {
            agentRepository.getAgentList().collect { resource ->
                when(resource) {
                    Resource.Loading -> {
                        _state.update {
                            it.copy(
                                isLoading = true,
                                agentList = emptyList(),
                                isError = null,
                            )
                        }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                agentList = resource.data,
                                isError = null,
                            )
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                agentList = emptyList(),
                                isError = resource.message,
                            )
                        }
                    }
                }
            }
        }
    }

}
package com.valorantproject.features.agentlist

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.valorantproject.core.ui.components.AgentCardItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AgentListScreen(
    viewModel: AgentListViewModel = hiltViewModel(),
    navigateToDetail: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                items(
                    items = state.agentList.orEmpty(),
                    key = { key -> key.uuid.toString() }
                ) { data ->
                    AgentCardItem(
                        data = data,
                        onCardClicked = {},
                        modifier = Modifier.size(250.dp)
                    )
                }
            }
        }
    }
}
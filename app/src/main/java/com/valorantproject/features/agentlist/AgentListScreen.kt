package com.valorantproject.features.agentlist

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AgentListScreen(
    navigateToDetail: () -> Unit,
) {
    Scaffold() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Home Screen", modifier = Modifier.clickable { navigateToDetail() })
        }
    }
}
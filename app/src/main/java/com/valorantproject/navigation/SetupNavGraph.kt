package com.valorantproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.valorantproject.features.agentdetail.AgentDetailScreen
import com.valorantproject.features.agentlist.AgentListScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = "/",
        modifier = modifier,
    ) {
        composable(route = "/") {
            AgentListScreen(
                navigateToDetail = {
                    navController.navigate("/agent-detail/1")
                }
            )
        }
        composable(
            route = "/agent-detail/{agentId}",
            arguments = listOf(
                navArgument(name = "agentId") {
                    type = NavType.IntType
                }
            )
        ) {
            AgentDetailScreen()
        }
    }
}
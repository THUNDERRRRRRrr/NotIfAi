package com.notifai.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

private data class NavDestination(
    val screen: Screen,
    val label: String,
    val icon: ImageVector,
)

private val destinations = listOf(
    NavDestination(Screen.Dashboard,   "Home",     Icons.Default.Home),
    NavDestination(Screen.Blocked,     "Blocked",  Icons.Default.Block),
    NavDestination(Screen.AppSettings, "Apps",     Icons.Default.Apps),
    NavDestination(Screen.Settings,    "Settings", Icons.Default.Settings),
)

@Composable
fun BottomNavBar(
    navController: NavController,
    blockedCount: Int,
) {
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route

    // Hide on onboarding
    AnimatedVisibility(
        visible = currentRoute != Screen.Onboarding.route,
        enter = slideInVertically { it },
        exit  = slideOutVertically { it },
    ) {
        NavigationBar {
            destinations.forEach { dest ->
                NavigationBarItem(
                    selected = currentRoute == dest.screen.route,
                    onClick = {
                        if (currentRoute != dest.screen.route) {
                            navController.navigate(dest.screen.route) {
                                popUpTo(Screen.Dashboard.route) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        if (dest.screen == Screen.Blocked && blockedCount > 0) {
                            BadgedBox(badge = {
                                Badge { Text(blockedCount.coerceAtMost(99).toString()) }
                            }) {
                                Icon(dest.icon, contentDescription = dest.label)
                            }
                        } else {
                            Icon(dest.icon, contentDescription = dest.label)
                        }
                    },
                    label = { Text(dest.label) },
                )
            }
        }
    }
}

package com.notifai.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notifai.ui.apps.AppSettingsScreen
import com.notifai.ui.blocked.BlockedScreen
import com.notifai.ui.blocked.BlockedViewModel
import com.notifai.ui.common.UiState
import com.notifai.ui.dashboard.DashboardScreen
import com.notifai.ui.onboarding.OnboardingScreen
import com.notifai.ui.onboarding.OnboardingViewModel
import com.notifai.ui.settings.SettingsScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    // Determine start destination once at composition time
    val onboardingViewModel: OnboardingViewModel = hiltViewModel()
    val startDestination = remember {
        if (onboardingViewModel.isOnboardingComplete()) Screen.Dashboard.route
        else Screen.Onboarding.route
    }

    // Observe blocked count for the badge
    val blockedViewModel: BlockedViewModel = hiltViewModel()
    val blockedState by blockedViewModel.blockedNotifications.collectAsStateWithLifecycle()
    val blockedCount = (blockedState as? UiState.Success)?.data?.size ?: 0

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                blockedCount = blockedCount,
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Screen.Onboarding.route) {
                OnboardingScreen(navController = navController)
            }
            composable(Screen.Dashboard.route) {
                DashboardScreen(navController = navController)
            }
            composable(Screen.Blocked.route) {
                BlockedScreen()
            }
            composable(Screen.AppSettings.route) {
                AppSettingsScreen()
            }
            composable(Screen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}

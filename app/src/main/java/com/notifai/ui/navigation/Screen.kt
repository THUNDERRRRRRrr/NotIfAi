package com.notifai.ui.navigation

/** Type-safe route definitions for the NavHost. */
sealed class Screen(val route: String) {
    data object Onboarding  : Screen("onboarding")
    data object Dashboard   : Screen("dashboard")
    data object Blocked     : Screen("blocked")
    data object AppSettings : Screen("apps")
    data object Settings    : Screen("settings")
}

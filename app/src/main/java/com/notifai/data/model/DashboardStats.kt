package com.notifai.data.model

/** Aggregated stats for the Dashboard screen. "Today" = since local midnight. */
data class DashboardStats(
    val todayBlocked: Int,
    val todayOTPs: Int,
    val todayDeliveries: Int,
    val todayPromotional: Int,
)

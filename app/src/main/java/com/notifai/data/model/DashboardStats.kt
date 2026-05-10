package com.notifai.data.model

/**
 * Aggregated stats derived from today's notifications, surfaced on the
 * Dashboard screen.
 *
 * "Today" is defined as the period from local midnight to now.
 */
data class DashboardStats(
    /** Total notifications blocked today. */
    val todayBlocked: Int,
    /** OTP notifications seen today (blocked + allowed). */
    val todayOTPs: Int,
    /** Delivery notifications seen today. */
    val todayDeliveries: Int,
    /** Promotional notifications seen today. */
    val todayPromotional: Int,
)

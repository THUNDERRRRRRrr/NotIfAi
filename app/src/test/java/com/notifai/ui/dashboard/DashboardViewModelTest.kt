package com.notifai.ui.dashboard

import android.content.ComponentName
import android.content.ContentResolver
import android.content.Context
import android.provider.Settings
import app.cash.turbine.test
import com.notifai.data.model.DashboardStats
import com.notifai.data.model.NotificationEntity
import com.notifai.data.repository.NotificationRepository
import com.notifai.service.NotifListenerService
import com.notifai.ui.common.UiState
import com.notifai.util.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.mockkStatic
import io.mockk.unmockkConstructor
import io.mockk.unmockkStatic
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DashboardViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: DashboardViewModel
    private val repository: NotificationRepository = mockk()
    private val context: Context = mockk()
    private val contentResolver: ContentResolver = mockk()

    @Before
    fun setup() {
        mockkStatic(Settings.Secure::class)
        mockkConstructor(ComponentName::class)
        every { anyConstructed<ComponentName>().flattenToString() } returns "com.notifai/com.notifai.service.NotifListenerService"

        every { context.contentResolver } returns contentResolver
        
        // Default to not running
        every { Settings.Secure.getString(contentResolver, "enabled_notification_listeners") } returns ""

        // Setup repository mock responses
        every { repository.getDashboardStats() } returns flowOf(
            DashboardStats(
                todayBlocked = 5,
                todayOTPs = 2,
                todayDeliveries = 3,
                todayPromotional = 1
            )
        )

        every { repository.getAllNotifications() } returns flowOf(
            listOf(
                mockk<NotificationEntity>(relaxed = true)
            )
        )

        every { repository.getTodayBlockedCount() } returns flowOf(5)
    }

    @After
    fun tearDown() {
        unmockkStatic(Settings.Secure::class)
        unmockkConstructor(ComponentName::class)
    }

    @Test
    fun `dashboardStats initially emits Loading, then Success`() = runTest {
        viewModel = DashboardViewModel(repository, context)

        viewModel.dashboardStats.test {
            // First emission is either Loading or already Success depending on how quickly flow is collected
            val initial = awaitItem()
            if (initial is UiState.Loading) {
                val success = awaitItem() as UiState.Success
                assertEquals(5, success.data.todayBlocked)
            } else if (initial is UiState.Success) {
                assertEquals(5, initial.data.todayBlocked)
            }
        }
    }

    @Test
    fun `dashboardStats handles errors by emitting Error state`() = runTest {
        val errorMessage = "Database error"
        every { repository.getDashboardStats() } returns flow {
            throw RuntimeException(errorMessage)
        }

        viewModel = DashboardViewModel(repository, context)

        viewModel.dashboardStats.test {
            val item = awaitItem()
            if (item is UiState.Loading) {
                val error = awaitItem() as UiState.Error
                assertTrue(error.message.contains("Failed to load stats"))
            } else {
                assertTrue(item is UiState.Error)
            }
        }
    }

    @Test
    fun `recentNotifications limits to 20 items`() = runTest {
        val mockNotifications = List(30) { mockk<NotificationEntity>(relaxed = true) }
        every { repository.getAllNotifications() } returns flowOf(mockNotifications)

        viewModel = DashboardViewModel(repository, context)

        viewModel.recentNotifications.test {
            val item = awaitItem()
            if (item is UiState.Loading) {
                val success = awaitItem() as UiState.Success
                assertEquals(20, success.data.size)
            } else if (item is UiState.Success) {
                assertEquals(20, item.data.size)
            }
        }
    }

    @Test
    fun `blockedToday returns value from repository`() = runTest {
        viewModel = DashboardViewModel(repository, context)

        viewModel.blockedToday.test {
            val item = awaitItem()
            if (item == 0) {
                // Loading or default state
                val successItem = awaitItem()
                assertEquals(5, successItem)
            } else {
                assertEquals(5, item)
            }
        }
    }

    @Test
    fun `checkServiceRunning returns true when component is in enabled_notification_listeners`() = runTest {
        val expectedComponent = "com.notifai/com.notifai.service.NotifListenerService"
        every { Settings.Secure.getString(contentResolver, "enabled_notification_listeners") } returns expectedComponent

        viewModel = DashboardViewModel(repository, context)
        
        viewModel.isServiceRunning.test {
            assertEquals(true, awaitItem())
        }
    }

    @Test
    fun `checkServiceRunning returns false when component is not in enabled_notification_listeners`() = runTest {
        every { Settings.Secure.getString(contentResolver, "enabled_notification_listeners") } returns "some.other.service"

        viewModel = DashboardViewModel(repository, context)

        viewModel.isServiceRunning.test {
            assertEquals(false, awaitItem())
        }
    }

    @Test
    fun `refreshServiceStatus updates isServiceRunning value`() = runTest {
        every { Settings.Secure.getString(contentResolver, "enabled_notification_listeners") } returns ""

        viewModel = DashboardViewModel(repository, context)

        viewModel.isServiceRunning.test {
            assertEquals(false, awaitItem())

            // Now enable it
            val expectedComponent = "com.notifai/com.notifai.service.NotifListenerService"
            every { Settings.Secure.getString(contentResolver, "enabled_notification_listeners") } returns expectedComponent

            viewModel.refreshServiceStatus()

            assertEquals(true, awaitItem())
        }
    }
}

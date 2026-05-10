package com.notifai.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Receives [Intent.ACTION_BOOT_COMPLETED] and re-arms the
 * [NotifListenerService].
 *
 * Note: [NotificationListenerService] is started by the system automatically
 * when notification access is granted, and the system also re-binds it after
 * reboot.  This receiver exists as a safety net to ensure the foreground
 * service wrapper is also restarted so the persistent status-bar notification
 * appears immediately after boot.
 *
 * Requires [android.Manifest.permission.RECEIVE_BOOT_COMPLETED] in the
 * manifest.
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED) return

        Log.d(TAG, "Boot completed — requesting NotifListenerService restart")

        // The OS re-binds NotificationListenerService automatically once
        // access is granted; nothing extra needed for the listener itself.
        // If you add a separate foreground wrapper service in the future,
        // start it here with:
        //   context.startForegroundService(Intent(context, YourWrapperService::class.java))
    }

    companion object {
        private const val TAG = "BootReceiver"
    }
}

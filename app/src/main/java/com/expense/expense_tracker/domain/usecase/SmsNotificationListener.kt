package com.expense.expense_tracker.domain.usecase

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class SmsNotificationListener : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val packageName = sbn.packageName
        val extras = sbn.notification.extras
        val title = extras.getString(Notification.EXTRA_TITLE)
        val text = extras.getCharSequence(Notification.EXTRA_TEXT)?.toString()

        if (packageName.contains("messaging") || packageName.contains("sms")) {
            text?.let {
                if (it.contains("debited") || it.contains("credited")) {
                    Log.d("SMS Notification", "Parsed message: $text")
                }
            }
        }
    }
}
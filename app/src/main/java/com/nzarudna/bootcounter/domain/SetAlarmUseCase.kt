package com.nzarudna.bootcounter.domain

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import com.nzarudna.bootcounter.receivers.AlarmReceiver
import javax.inject.Inject
import javax.inject.Singleton

private const val DELAY_15_MIN = 15 * 60 * 1000L

class SetAlarmUseCase(
    private val context: Context
) {

    operator fun invoke() {

        val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            123,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP, DELAY_15_MIN, pendingIntent
        )
    }
}


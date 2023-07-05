package com.nzarudna.bootcounter.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.nzarudna.bootcounter.data.BootLogsRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class BootEventReceiver : BroadcastReceiver() {

    @Inject
    lateinit var bootLogsRepository: BootLogsRepository

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
                CoroutineScope(SupervisorJob()).launch() {
                    bootLogsRepository.saveNewLog(Date())
                }
            }
        }
    }
}
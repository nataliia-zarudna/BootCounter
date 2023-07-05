package com.nzarudna.bootcounter.domain

import com.nzarudna.bootcounter.data.db.entity.BootLog

class FormatLogStringUseCase {

    operator fun invoke(lastLogs: List<BootLog>) = when {
        lastLogs.isEmpty() -> "No boots detected"
        lastLogs.size == 1 -> "The boot was detected with the timestamp = ${lastLogs[0].bootTime}"
        else -> "Last boots time delta = ${lastLogs[1].bootTime.time - lastLogs[0].bootTime.time}"
    }
}
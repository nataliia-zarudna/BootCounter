package com.nzarudna.bootcounter.data

import com.nzarudna.bootcounter.data.db.dao.BootLogDao
import com.nzarudna.bootcounter.data.db.entity.BootLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BootLogsRepository @Inject constructor(
    private val bootLogDao: BootLogDao
) {

    fun getLastLogs(): List<BootLog> =
        bootLogDao.getLastBootLogs(2)

    suspend fun saveNewLog(time: Date) = withContext(Dispatchers.IO) {
        bootLogDao.insert(BootLog(bootTime = time))
    }
} 
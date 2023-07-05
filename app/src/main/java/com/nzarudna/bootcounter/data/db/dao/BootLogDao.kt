package com.nzarudna.bootcounter.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nzarudna.bootcounter.data.db.entity.BootLog

@Dao
interface BootLogDao {

    @Insert
    suspend fun insert(bootLog: BootLog): Long

    @Update
    suspend fun update(bootLog: BootLog)

    @Delete
    suspend fun delete(vararg bootLog: BootLog)

    @Query("SELECT * FROM boot_logs ORDER BY boot_time DESC LIMIT :limit")
    fun getLastBootLogs(limit: Int): List<BootLog>
}
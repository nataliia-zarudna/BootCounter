package com.nzarudna.bootcounter.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "boot_logs")
data class BootLog(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo("boot_time")
    val bootTime: Date
)
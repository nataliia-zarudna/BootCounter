package com.nzarudna.bootcounter.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nzarudna.bootcounter.data.db.dao.BootLogDao
import com.nzarudna.bootcounter.data.db.entity.BootLog

@Database(
    entities = [BootLog::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class BootLogsDatabase : RoomDatabase() {

    abstract fun bootLogDao(): BootLogDao

    companion object {

        @Volatile
        private var INSTANCE: BootLogsDatabase? = null

        fun getDatabase(context: Context): BootLogsDatabase {
            val instance = INSTANCE ?: buildDatabase(context)
            INSTANCE = instance
            return instance
        }

        private fun buildDatabase(context: Context): BootLogsDatabase {
            return Room
                .databaseBuilder(context, BootLogsDatabase::class.java, "bootlogs.db")
                .build()
        }
    }
}
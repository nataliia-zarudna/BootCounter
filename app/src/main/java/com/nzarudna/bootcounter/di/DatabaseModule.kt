package com.nzarudna.bootcounter.di

import android.content.Context
import com.nzarudna.bootcounter.data.db.BootLogsDatabase
import com.nzarudna.bootcounter.data.db.dao.BootLogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideBootLogsDatabase(@ApplicationContext context: Context): BootLogsDatabase =
        BootLogsDatabase.getDatabase(context)

    @Provides
    fun provideBootLogsDao(bootLogsDatabase: BootLogsDatabase): BootLogDao = bootLogsDatabase.bootLogDao()
}
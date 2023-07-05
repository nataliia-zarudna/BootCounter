package com.nzarudna.bootcounter.data.db

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date

class Converters {

    private val DATE_FORMATTER = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

    @TypeConverter
    fun dateToString(date: Date?): String? {
        return date?.let { DATE_FORMATTER.format(date) }
    }

    @TypeConverter
    fun stringToDate(value: String?): Date? {
        return value?.let { DATE_FORMATTER.parse(value) }
    }

}
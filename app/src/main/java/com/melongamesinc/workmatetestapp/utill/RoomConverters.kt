package com.melongamesinc.workmatetestapp.utill

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class RoomConverters {
    @TypeConverter
    fun fromList(list: List<String>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        return Json.decodeFromString(value)
    }
}
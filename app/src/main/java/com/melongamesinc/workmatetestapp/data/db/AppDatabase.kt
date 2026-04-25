package com.melongamesinc.workmatetestapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.melongamesinc.workmatetestapp.data.entities.CharacterEntity
import com.melongamesinc.workmatetestapp.utill.RoomConverters

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDao
}
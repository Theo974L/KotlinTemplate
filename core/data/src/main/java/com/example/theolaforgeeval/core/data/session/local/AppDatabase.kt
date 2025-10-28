package com.example.theolaforgeeval.core.data.session.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.theolaforgeeval.core.data.session.dao.UserSessionDao
import com.example.theolaforgeeval.core.data.session.entity.UserSessionEntity

@Database(
    entities = [UserSessionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userSessionDao(): UserSessionDao
}
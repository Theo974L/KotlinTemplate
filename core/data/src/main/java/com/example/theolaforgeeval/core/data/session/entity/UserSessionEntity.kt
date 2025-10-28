package com.example.theolaforgeeval.core.data.session.entity



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_session")
data class UserSessionEntity(
    @PrimaryKey val userId: String
)
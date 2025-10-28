package com.example.theolaforgeeval.core.domain.repository

import com.example.theolaforgeeval.core.domain.model.session.UserSession
import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    fun getUserSession(): Flow<UserSession?>
    suspend fun saveUserSession(userSession: UserSession)
    suspend fun clearUserSession()
}
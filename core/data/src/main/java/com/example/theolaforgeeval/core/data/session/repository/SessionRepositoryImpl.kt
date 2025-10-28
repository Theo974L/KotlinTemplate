package com.example.theolaforgeeval.core.data.session.repository

import com.example.theolaforgeeval.core.data.session.dao.UserSessionDao
import com.example.theolaforgeeval.core.data.session.entity.UserSessionEntity
import com.example.theolaforgeeval.core.domain.model.session.UserSession
import com.example.theolaforgeeval.core.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SessionRepositoryImpl(
    private val dao: UserSessionDao
) : SessionRepository {

    override fun getUserSession(): Flow<UserSession?> =
        dao.getUserSession().map { it?.toDomain() }

    override suspend fun saveUserSession(userSession: UserSession) {
        dao.saveUserSession(userSession.toEntity())
    }

    override suspend fun clearUserSession() {
        dao.clearUserSession()
    }

    private fun UserSessionEntity.toDomain() = UserSession(userId)
    private fun UserSession.toEntity() = UserSessionEntity(userId)
}
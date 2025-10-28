package com.example.theolaforgeeval.api

import com.example.theolaforgeeval.core.data.session.repository.SessionRepositoryImpl
import com.example.theolaforgeeval.core.domain.repository.SessionRepository
import org.koin.dsl.module

val SessionModule = module {
    single<SessionRepository> { SessionRepositoryImpl(get()) }
}
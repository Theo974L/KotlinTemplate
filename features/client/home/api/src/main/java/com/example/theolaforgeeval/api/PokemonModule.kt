package com.example.theolaforgeeval.api

import android.app.Application
import com.example.theolaforgeeval.data.repository.PokemonRepositoryImpl
import com.example.theolaforgeeval.repository.PokemonRepository
import org.koin.dsl.module

val PokemonModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get<Application>()) }
}
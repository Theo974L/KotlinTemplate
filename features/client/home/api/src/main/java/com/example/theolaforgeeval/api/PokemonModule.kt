package com.example.theolaforgeeval.api

import android.app.Application
import com.example.theolaforgeeval.data.repository.PokemonRepositoryImpl
import com.example.theolaforgeeval.repository.PokemonRepository
import org.koin.dsl.module

/**
 * @properties PokemonModule c'est pour l'injetion de dependance de PokemonRepositoryImpl
 * @see PokemonModule est un singleton
 */

val PokemonModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get<Application>()) }
}
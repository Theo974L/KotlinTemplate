package com.example.theolaforgeeval.data.api

import android.util.Log
import com.example.theolaforgeeval.repository.PokemonRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokemonRepositoryImpl : PokemonRepository {

    override suspend fun getPokemons(): Void {

        val response: HttpResponse = client.get("https://tyradex.app/api/v1/pokemon").body()

        Log.d("Pokemon", response.toString())


        return TODO("Provide the return value")
    }

}

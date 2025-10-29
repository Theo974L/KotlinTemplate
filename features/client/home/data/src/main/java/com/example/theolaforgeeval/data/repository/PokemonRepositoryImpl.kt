package com.example.theolaforgeeval.data.repository
import android.content.Context
import android.util.Log
import com.example.theolaforgeeval.data.local.dao.PokemonDao
import com.example.theolaforgeeval.data.local.database.AppDatabase
import com.example.theolaforgeeval.data.mapping.toPokemonModel
import com.example.theolaforgeeval.model.PokemonDto
import com.example.theolaforgeeval.model.PokemonModel
import com.example.theolaforgeeval.repository.PokemonRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokemonRepositoryImpl(
    private val context: Context
): PokemonRepository {


    private val dao: PokemonDao by lazy {
        AppDatabase.getDatabase(context).pokemonDao()
    }


    val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }

    override suspend fun getPokemons(): List<PokemonModel> {
        return try {


            // 1️⃣ Récupération depuis l'API
            val json = client.get("https://tyradex.app/api/v1/pokemon").bodyAsText()
            Log.d("PokemonRepositoryImpl", "JSON received: ${json.take(300)}")

            val dtoList = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.decodeFromString<List<PokemonDto>>(json)

            Log.d("PokemonRepositoryImpl", "Parsed DTO count: ${dtoList.size}")

            // 2️⃣ Convertir en Entity et sauvegarder Room
            val entities = dtoList.take(20).map { it.toPokemonModel() }
            dao.insertAll(entities)

            entities

        } catch (e: Exception) {
            Log.e("PokemonRepositoryImpl", "Erreur parsing JSON: ${e.message}", e)
            // fallback: récupérer depuis Room
            dao.getAllPokemons()
        }
    }

    override suspend fun getPokemonById(id: Int): PokemonModel? {
        return try {
            // 1️⃣ API
            val json = client.get("https://tyradex.app/api/v1/pokemon/$id").bodyAsText()
            Log.d("PokemonRepositoryImpl", "JSON for ID $id: ${json.take(300)}")

            val dto = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.decodeFromString<PokemonDto>(json)

            // 2️⃣ Sauvegarder dans Room
            val entity = dto.toPokemonModel()
            dao.insertAll(listOf(entity))

            // 3️⃣ Retourner pour le UI
            entity
        } catch (e: Exception) {
            Log.e("PokemonRepositoryImpl", "Erreur getPokemonById($id): ${e.message}", e)
            // fallback: Room
            dao.getPokemonById(id)
        }
    }

}
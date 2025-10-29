package com.example.theolaforgeeval.data.local.dao

import androidx.room.*
import com.example.theolaforgeeval.model.PokemonModel

/**
 * Le DAO pour la bdd en local, permet d'effectuer des requêtes sur la bdd
 */

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemons(): List<PokemonModel>

    @Query("SELECT * FROM pokemon WHERE id = :id LIMIT 1")
    suspend fun getPokemonById(id: Int): PokemonModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonModel)

    @Query("DELETE FROM pokemon")
    suspend fun clearAll()
}
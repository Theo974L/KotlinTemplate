package com.example.theolaforgeeval.data.local.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.theolaforgeeval.data.local.dao.PokemonDao
import com.example.theolaforgeeval.model.PokemonModel

/**
 * Représente la base de données locale de l'application pour stocker les entités [PokemonModel].
 *
 * @property pokemonDao L'accès aux opérations CRUD pour les entités [PokemonModel].
 *
 * @property getDatabase Pour obtenir une instance de la base de données.
 */

@Database(entities = [PokemonModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        // @Volatile sert a exposer cette instance a tous les thread
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            // Synchronized permet d'éviter les conflits de thread (Pour pas qu'il creer plusieurs instance)
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pokemon"
                ).build().also { INSTANCE = it }
            }
    }
}
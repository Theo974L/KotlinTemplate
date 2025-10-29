package com.example.theolaforgeeval.data.local.database


import androidx.room.TypeConverter
import com.example.theolaforgeeval.model.PokemonModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        if (value == null) return emptyList()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }

    // Exemple pour un objet custom (Stats, Abilities, etc.)
    @TypeConverter
    fun fromPokemonModel(pokemon: PokemonModel?): String? {
        return gson.toJson(pokemon)
    }

    @TypeConverter
    fun toPokemonModel(value: String?): PokemonModel? {
        if (value == null) return null
        return gson.fromJson(value, PokemonModel::class.java)
    }
}
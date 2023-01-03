package com.darkgreen.pokedex.api

import android.util.Log
import com.darkgreen.pokedex.api.model.PokemonApiResult
import com.darkgreen.pokedex.api.model.PokemonsApiResult
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class PokemonRepository  {

    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service =  retrofit.create(PokemonService::class.java)
    }

    fun getPokemons(limit: Int = 151){
        val call = service.listPokemons(limit)

        call.enqueue(object : Callback<PokemonsApiResult>{

        }
    }
}
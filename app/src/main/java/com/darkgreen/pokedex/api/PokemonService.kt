package com.darkgreen.pokedex.api

import com.darkgreen.pokedex.api.model.PokemonApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listPokemon(@Query("limit") limit: Int): Call<PokemonApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number: Int) : Call<PokemonApiResult>

}
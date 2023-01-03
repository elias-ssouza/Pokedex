package com.darkgreen.pokedex.api

import com.darkgreen.pokedex.api.model.PokemonApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int = 151): Call<PokemonApiResult>

    @GET("pokemon/{number}")
    fun getPokemons(number: Int) : Call<PokemonApiResult>

}
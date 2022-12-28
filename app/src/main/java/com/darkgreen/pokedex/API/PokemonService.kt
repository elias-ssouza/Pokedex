package com.darkgreen.pokedex.API

import com.darkgreen.pokedex.API.model.PokemonApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listRepos(@Query("user") user:String?): Call<List<PokemonApiResult?>?>?


}
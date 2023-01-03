package com.darkgreen.pokedex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.darkgreen.pokedex.Domain.Pokemon
import com.darkgreen.pokedex.Domain.PokemonType
import com.darkgreen.pokedex.R
import com.darkgreen.pokedex.api.PokemonRepository
import com.darkgreen.pokedex.api.PokemonService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_pokemon)

        val layoutManager = LinearLayoutManager(this)

        val pikachu = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/025.png",
            1,
            "Pikachu",
            listOf(
                PokemonType("Eletric")
            )
        )
        val pokemons = listOf(pikachu, pikachu, pikachu)

        val pokemonsApi = PokemonRepository.listPokemons()

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}
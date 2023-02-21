package com.darkgreen.pokedex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.darkgreen.pokedex.Domain.Pokemon
import com.darkgreen.pokedex.Domain.PokemonType
import com.darkgreen.pokedex.R
import com.darkgreen.pokedex.ViewModel.PokemonViewModel
import com.darkgreen.pokedex.ViewModel.PokemonViewModelFactory
import com.darkgreen.pokedex.api.PokemonRepository
import com.darkgreen.pokedex.api.PokemonService

class MainActivity : AppCompatActivity() {
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_Pokemons)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it as List<Pokemon>)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}
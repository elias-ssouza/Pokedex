package com.darkgreen.pokedex.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.darkgreen.pokedex.Domain.Pokemon
import com.darkgreen.pokedex.R

class PokemonAdapter (
    private val items: List<Pokemon>
): RecyclerView.Adapter<PokemonAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    override fun getItemCount() =  items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView){
            val ivPokemon = findViewById<ImageView>(R.id.iv_pokemon)
            val tvNumber = findViewById<TextView>(R.id.tv_number)
            val tvName = findViewById<TextView>(R.id.tv_name)
            val tvPokemonType1 = findViewById<TextView>(R.id.tv_pokemon_type1)
            val tvPokemonType2 = findViewById<TextView>(R.id.tv_pokemon_type2)

            //TODO: Glide

            tvNumber.text = "Nº ${item.number}"
            tvName.text = item.name
            tvPokemonType1.text = item.types[0].name

            if (item.types.size >1) {
                tvPokemonType2.visibility = View.VISIBLE
                tvPokemonType2.text = item.types [1].name
            } else {
                tvPokemonType2.visibility = View.GONE
            }

        }
    }

}
package br.com.lucasgabriel.pokemon.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results")val conteudo: List<Pokemon>
)
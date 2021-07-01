package br.com.heiderlopes.pokemonwstemplate.repository

import br.com.heiderlopes.pokemonwstemplate.model.Pokemon

interface PokemonRepository {
    fun checkHealth(
        onComplete: () -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getPokemonList(
        offset: Int,
        limit: Int,
        onComplete: (List<Pokemon>?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun updatePokemon(
        pokemon: Pokemon,
        onComplete:(Pokemon?) -> Unit,
        onError:(Throwable) -> Unit
    )

}

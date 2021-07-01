package br.com.heiderlopes.pokemonwstemplate.api

import br.com.heiderlopes.pokemonwstemplate.model.HealthResponse
import br.com.heiderlopes.pokemonwstemplate.model.Pokemon
import br.com.heiderlopes.pokemonwstemplate.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.*

interface PokemonService {
    @GET("/api/v2")
    fun checkHealth(): Call<HealthResponse>

    @GET("/api/v2/pokemon")
    fun getPokemons(
        @Query("offset") size: Int,
        @Query("limit") limit: Int
    ): Call<PokemonResponse>

    @GET("/api/v2/pokemon/{id}")
    fun getPokemon(
        @Field("id") id: Int
    ): Call<Pokemon>

    @PUT("/api/v2/pokemon")
    fun updatePokemon(
        @Body pokemon: Pokemon
    ) : Call<Pokemon>

}

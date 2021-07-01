package br.com.lucasgabriel.pokemon.repository

import br.com.lucasgabriel.pokemon.api.PokemonService
import br.com.lucasgabriel.pokemon.model.HealthResponse
import br.com.lucasgabriel.pokemon.model.Pokemon
import br.com.lucasgabriel.pokemon.model.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class PokemonRepositoryImpl(val pokemonService: PokemonService) : PokemonRepository {

    private var log = Logger.getLogger("PokemonRepositoryImpl")

    override fun checkHealth(onComplete: () -> Unit, onError: (Throwable?) -> Unit) {
        pokemonService
            .checkHealth()
            .enqueue(object : Callback<HealthResponse> {
                override fun onFailure(call: Call<HealthResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<HealthResponse>,
                    response: Response<HealthResponse>
                ) {
                    if (response.isSuccessful) {
                        onComplete()
                    } else {
                        onError(Throwable("Erro na chamada"))
                    }
                }
            })
    }

    override fun getPokemonList(
        offset: Int,
        limit: Int,
        onComplete: (List<Pokemon>?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        pokemonService.getPokemons(offset, limit)
            .enqueue(object : Callback<PokemonResponse> {
                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if (response.isSuccessful) {
                        val list = response.body()?.conteudo
                        list?.forEach {
                            it.id = it.url.split("/").filterNot { it.isNullOrBlank() }.last()
                            it.url_imagem_front = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it.id}.png"
                            it.url_imagem_back = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/${it.id}.png"
                        }
                        onComplete(list)
                    } else {
                        onError(Throwable("Erro ao recuperar os Pokemons"))
                    }
                }
            })
    }

    override fun updatePokemon(
        pokemon: Pokemon,
        onComplete: (Pokemon?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        pokemonService
            .updatePokemon(pokemon)
            .enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<Pokemon>,
                    response: Response<Pokemon>
                ) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível atualizar o Pokémon"))
                    }
                }
            })
    }

}
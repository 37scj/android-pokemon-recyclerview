package br.com.lucasgabriel.pokemon.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lucasgabriel.pokemon.model.Pokemon
import br.com.lucasgabriel.pokemon.repository.PokemonRepository

class ListPokemonsViewModel (val pokemonRepository: PokemonRepository) : ViewModel() {

    val messageError: MutableLiveData<String> = MutableLiveData()
    val pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getPokemons() {
        isLoading.value = true
        pokemonRepository.getPokemonList(
            0, 150, {
                pokemons.value = it
                messageError.value = ""
                isLoading.value = false
            }, {
                pokemons.value = emptyList()
                messageError.value = it?.message
                isLoading.value = false
            }
        )
    }
}

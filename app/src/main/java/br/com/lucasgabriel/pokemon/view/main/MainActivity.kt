package br.com.lucasgabriel.pokemon.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lucasgabriel.pokemon.R
import br.com.lucasgabriel.pokemon.view.about.AboutActivity
import br.com.lucasgabriel.pokemon.view.list.ListPokemonsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSobre.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        btPokemonList.setOnClickListener {
            startActivity(Intent(this, ListPokemonsActivity::class.java))
        }

        btClose.setOnClickListener {
            finish()
        }
    }
}

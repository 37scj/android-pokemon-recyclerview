package br.com.lucasgabriel.pokemon.view.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lucasgabriel.pokemon.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        btClose.setOnClickListener {
            finish()
        }

    }
}
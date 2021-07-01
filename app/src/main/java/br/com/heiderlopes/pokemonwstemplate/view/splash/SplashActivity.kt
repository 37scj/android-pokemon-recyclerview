package br.com.heiderlopes.pokemonwstemplate.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.heiderlopes.pokemonwstemplate.R
import br.com.heiderlopes.pokemonwstemplate.api.PokemonService
import br.com.heiderlopes.pokemonwstemplate.repository.PokemonRepository
import br.com.heiderlopes.pokemonwstemplate.repository.PokemonRepositoryImpl
import br.com.heiderlopes.pokemonwstemplate.view.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.checkHealth()

        splashViewModel.messageError.observe(this, Observer {
            if (it.isNullOrEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }
}

package br.com.lucasgabriel.pokemon.view.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.lucasgabriel.pokemon.R
import br.com.lucasgabriel.pokemon.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_form_pokemon.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class FormPokemonActivity : AppCompatActivity() {

    val formPokemonViewModel: FormPokemonViewModel by viewModel()

    val picasso: Picasso by inject()

    lateinit var pokemon : Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pokemon)

        setValues()

        formPokemonViewModel.messageResponse.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        btSaveForm.setOnClickListener {
//            pokemon.ataque = sbAttack.progress
//            pokemon.defesa = sbDefense.progress
//            pokemon.velocidade = sbVelocity.progress
//            pokemon.ps = sbPS.progress

            formPokemonViewModel.updatePokemon(pokemon)
        }
    }

    private fun setValues() {
        this.pokemon = intent.getParcelableExtra<Pokemon>("POKEMON")
        tvPokemonNameForm.text = pokemon.nome

        picasso.load(pokemon.url_imagem_front).into(ivPokemonForm)

//        sbAttack.progress = pokemon.ataque
//        sbDefense.progress = pokemon.defesa
//        sbPS.progress = pokemon.ps
//        sbVelocity.progress = pokemon.velocidade

//        tvAttackValue.text = pokemon.ataque.toString()
//        tvDefenseValue.text = pokemon.defesa.toString()
//        tvPSValue.text = pokemon.ps.toString()
//        tvVelocityValue.text = pokemon.velocidade.toString()

        setListener(sbAttack, tvAttackValue)
        setListener(sbDefense, tvDefenseValue)
        setListener(sbVelocity, tvVelocityValue)
        setListener(sbPS, tvPSValue)
    }

    private fun setListener(seekBar: SeekBar, textView: TextView) {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}

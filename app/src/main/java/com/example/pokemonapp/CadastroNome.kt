package com.example.pokemonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_nome.*

class CadastroNome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_nome)


        next.setOnClickListener {

            val nome = cadastro_nome.text.toString()


            val intent = Intent(this, CadastroPokemon::class.java)
            intent.putExtra("nome",nome)
            startActivity(intent)
        }


    }
}

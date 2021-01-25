package com.example.pokemonapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_cadastro_pokemon.*
import java.net.URL

class CadastroPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_pokemon)

        val nome = intent.getStringExtra("nome")

        text1.text = "Olá, $nome"


        load()



    }

    fun load() {
        val url = "https://vortigo.blob.core.windows.net/files/pokemon/data/types.json"

        val jor = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            val data = ArrayList<String>()

            val results = response.getJSONArray("results")
            for (i in 0 until results.length()) {
                val nome = results.getJSONObject(i).getString("name")
                data.add(nome)
            }

            val spinnerAdapter = ArrayAdapter(this, R.layout.pokemon_list_item, data)

            cadastro_pokemon.adapter = spinnerAdapter



        }, {

        })

        Volley.newRequestQueue(this).add(jor)

    }

}
package com.example.pokemonapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_list_item.view.*


class TypesAdapter(
        context: Context,
        val layout: Int,
        val data: ArrayList<String>,
        val list: ArrayList<TypePokemons>
) : ArrayAdapter<String>(context, layout, data) {


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(layout, parent, false)
        val type: TypePokemons = list[position]

        view.text1.text = type.name

        Picasso.get().load(type.thumbnailImage).into(view.icon)

        return view
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(layout, parent, false)

        view.text1.text = data[position]
        return view
    }
}
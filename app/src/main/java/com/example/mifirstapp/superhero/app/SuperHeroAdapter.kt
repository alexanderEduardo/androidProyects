package com.example.mifirstapp.superhero.app

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mifirstapp.R
import com.example.mifirstapp.utils.AdapterGeneric
import com.example.mifirstapp.utils.ViewHolderGeneric

class SuperHeroAdapter(private var heroes: List<SuperHero> = emptyList()) : AdapterGeneric<SuperHero>(heroes){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<SuperHero> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superheroe, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric<SuperHero>, position: Int) {
        holder.render(heroes[position])
    }

    override fun getItemCount(): Int = heroes.size

    override fun getList(): List<SuperHero> = heroes
    @SuppressLint("NotifyDataSetChanged")
    override fun setList(list: List<SuperHero>) {
        this.heroes = list
        notifyDataSetChanged()
    }

}
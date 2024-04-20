package com.example.mifirstapp.superhero.app

import android.view.View
import com.example.mifirstapp.databinding.ItemSuperheroeBinding
import com.example.mifirstapp.utils.ViewHolderGeneric
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View, private val onItemSelected: (String)-> Unit) : ViewHolderGeneric<SuperHero>(view) {

    private val binding = ItemSuperheroeBinding.bind(view)

    override fun render(dataRv: SuperHero) {
        binding.tvSuperHeroName.text = dataRv.name
        Picasso.get().load(dataRv.image.url).into(binding.ivSuperHeroImage)

        //itemView is eq to view and is the root view of the layout
        //binding.root is eq to view and is the root view of the layout
        itemView.setOnClickListener { onItemSelected(dataRv.id) }

    }
}
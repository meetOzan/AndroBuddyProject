package com.mertozan.androbuddyproject.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mertozan.androbuddyproject.R
import com.mertozan.androbuddyproject.data.model.ValorantModel
import com.mertozan.androbuddyproject.databinding.CharacterItemCardBinding

class CharacterListAdapter(private val characterItems: List<ValorantModel>) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CharacterItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: ValorantModel){
            with(binding){
                textCharacterName.text = character.name
                Glide.with(imageCharacter.context)
                    .load(character.displayIcon)
                    .into(imageCharacter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = characterItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterItems[position])
    }

}

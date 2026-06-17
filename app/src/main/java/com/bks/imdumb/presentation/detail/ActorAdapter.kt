package com.bks.imdumb.presentation.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bks.imdumb.R
import com.bks.imdumb.domain.model.Actor
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class ActorAdapter(private val actors: List<Actor>) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount(): Int = actors.size

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivPhoto: ImageView = itemView.findViewById(R.id.ivActorPhoto)
        private val tvName: TextView = itemView.findViewById(R.id.tvActorName)
        private val tvCharacter: TextView = itemView.findViewById(R.id.tvCharacterName)

        fun bind(actor: Actor) {
            tvName.text = actor.name
            tvCharacter.text = actor.character
            
            Glide.with(itemView.context)
                .load(actor.photoUrl)
                .placeholder(R.drawable.placeholder_movie)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivPhoto)
        }
    }
}

package com.example.algeriansupremecourt.features.arret

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.algeriansupremecourt.R

class ArretAdapter : RecyclerView.Adapter<ArretAdapter.ViewHolder>() {
    var onItemClick: (() -> Unit)? = null

    private var arrets: List<ArretModel> = emptyList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numArret: TextView = itemView.findViewById(R.id.textViewNumArret)
        val chambreArret: TextView = itemView.findViewById(R.id.textViewChambreArret)
        val dateArret: TextView = itemView.findViewById(R.id.textViewDateArret)
        val imageViewFavorite: ImageView = itemView.findViewById(R.id.imageViewFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_arret, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentArret = arrets[position]
        holder.numArret.text = currentArret.numArret
        holder.chambreArret.text = currentArret.chambreArret
        holder.dateArret.text = currentArret.dateArret
        if (currentArret.isFavorite) {
            holder.imageViewFavorite.visibility = View.VISIBLE
        } else {
            holder.imageViewFavorite.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return arrets.size
    }

    fun updateData(newArrets: List<ArretModel>) {
        arrets = newArrets
        notifyDataSetChanged()
    }
}


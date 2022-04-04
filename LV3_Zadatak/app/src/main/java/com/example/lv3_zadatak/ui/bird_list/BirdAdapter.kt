package com.example.lv3_zadatak.ui.bird_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lv3_zadatak.R
import com.example.lv3_zadatak.databinding.ItemBirdBinding
import com.example.lv3_zadatak.model.Bird

class BirdAdapter : RecyclerView.Adapter<BirdViewHolder>() {

    private val birds = mutableListOf<Bird>()
    var onTaskSelectedListener: OnBirdEventListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bird, parent, false)
        return BirdViewHolder(view)
    }
    fun setBirds(birds: List<Bird>) {
        this.birds.clear()
        this.birds.addAll(birds)
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val task = birds[position]
        holder.bind(task)
        onTaskSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.onBirdSelected(task.id) }
            holder.itemView.setOnLongClickListener { listener.onBirdLongPress(task) }
        }    }

    override fun getItemCount(): Int {
        return birds.count()
    }
}


class BirdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bird: Bird){
            val binding =ItemBirdBinding.bind(itemView)
            val colour = bird.colour
            binding.itemBirdName.text=bird.name
            binding.root.setBackgroundResource(R.color.green)
            binding.itemBirdColour.setBackgroundResource(androidx.appcompat.R.color.material_blue_grey_800)
        }



}
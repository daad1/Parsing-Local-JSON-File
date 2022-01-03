package com.example.parsinglocaljsonfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parsinglocaljsonfile.databinding.ItemRowBinding
import com.squareup.picasso.Picasso

class RVAdapter(val imageList: ArrayList<String>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>()  {

    class ItemViewHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
      holder.binding.apply {
          Picasso.get().load(imageList[position]).resize(300, 300).into(imageData)
      }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}
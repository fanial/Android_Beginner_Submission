package com.codefal.android_beginner.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codefal.android_beginner.DetailActivity
import com.codefal.android_beginner.databinding.ItemListBinding
import com.codefal.android_beginner.model.DataList

class AdapterList(private val data: ArrayList<DataList>): RecyclerView.Adapter<AdapterList.ViewHolder>() {

    class ViewHolder(var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvJudul.text = data[position].judul
        holder.binding.tvIsi.text = data[position].isi
        holder.binding.imageList.setImageResource(data[position].pic)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("key_data", data[position])
            holder.itemView.context.startActivity(intent)
        }
    }

}
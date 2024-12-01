package com.deranaindonesia.home.ui.adapter.beranda.feature


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.home.data.beranda.feature.DataItem

import com.deranaindonesia.ui.databinding.ItemFiturBinding

class AllfiturAdapter(
    private val items:List<DataItem>
): RecyclerView.Adapter<AllfiturAdapter.ProdukViewHolder>() {
    class ProdukViewHolder(val binding: ItemFiturBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val binding = ItemFiturBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdukViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding){
            icProduk.setImageResource(item.iconRes)
            txtProduk.text =item.namaProduk
        }
    }
}
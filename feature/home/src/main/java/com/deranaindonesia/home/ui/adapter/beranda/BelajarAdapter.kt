package com.deranaindonesia.home.ui.adapter.beranda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.deranaindonesia.home.data.beranda.DataBelajar
import com.deranaindonesia.ui.databinding.ItemBelajarBinding
import com.google.android.material.card.MaterialCardView


class BelajarAdapter(private var items: List<DataBelajar>) :
    RecyclerView.Adapter<BelajarAdapter.BelajarViewHolder>() {

    class BelajarViewHolder(val binding: ItemBelajarBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BelajarViewHolder {
        val binding = ItemBelajarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BelajarViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BelajarViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            judulBelajar.text = item.title
            episodeBelajar.text = item.episode
            imgBelajar.setImageResource(item.imageRes)
            progressBar.progress = item.progress
            (root as MaterialCardView).setCardBackgroundColor(item.backgroundColor)
        }
    }

    fun updateData(newItems: List<DataBelajar>) {
        items = newItems
        notifyDataSetChanged()
    }
}

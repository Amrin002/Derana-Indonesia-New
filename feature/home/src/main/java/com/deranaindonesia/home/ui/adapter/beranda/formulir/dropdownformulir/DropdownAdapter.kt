package com.deranaindonesia.home.ui.adapter.beranda.formulir.dropdownformulir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.ui.R

class DropdownAdapter(
    private val options: List<String>,
    private val onOptionSelected: (String) -> Unit
): RecyclerView.Adapter<DropdownAdapter.OptionViewHolder>() {
    inner class OptionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val optionText: TextView = itemView.findViewById(R.id.optionText)

        fun bind(option: String) {
            optionText.text = option
            itemView.setOnClickListener {
                onOptionSelected(option)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.formulir_option_bottom_sheet_layout, parent, false)
        return OptionViewHolder(view)
    }

    override fun getItemCount(): Int = options.size

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.bind(options[position])
    }
}
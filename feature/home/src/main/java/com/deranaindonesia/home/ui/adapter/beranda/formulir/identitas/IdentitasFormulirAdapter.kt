package com.deranaindonesia.home.ui.adapter.beranda.formulir.identitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.home.data.beranda.formulir.FormulirItem
import com.deranaindonesia.home.ui.adapter.beranda.formulir.dropdownformulir.DropdownAdapter
import com.deranaindonesia.ui.R


class IdentitasFormulirAdapter(private val items: List<FormulirItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val TYPE_DROPDOWN = 0
        private const val TYPE_INPUT_FIELD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is FormulirItem.Dropdown -> TYPE_DROPDOWN
            is FormulirItem.InputField -> TYPE_INPUT_FIELD
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            TYPE_DROPDOWN -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.formulir_dropdown_layout, parent,false)
                DropdownViewHolder(view)
            }
            TYPE_INPUT_FIELD -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.formulir_input_layout, parent, false)
                InputFieldViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DropdownViewHolder -> {
                val item = items[position] as FormulirItem.Dropdown
                holder.bind(item)
            }
            is InputFieldViewHolder -> {
                val item = items[position] as FormulirItem.InputField
                holder.bind(item)
            }
        }
    }

    // ViewHolder untuk Dropdown
    inner class DropdownViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.inputFormulirDropdown)

        fun bind(item: FormulirItem.Dropdown) {
            textView.text = item.label
            itemView.setOnClickListener {
                // Tambahkan logika untuk menampilkan dropdown
                showDropdownWithRecyclerView(item.options)
            }
        }
        private fun showDropdownWithRecyclerView(options: List<String>) {
            // Inflate layout dialog untuk dropdown dengan RecyclerView
            val dialogView = LayoutInflater.from(itemView.context)
                .inflate(R.layout.formulir_bottom_sheet_layout, null)

            // Buat dialog terlebih dahulu
            val dialog = android.app.AlertDialog.Builder(itemView.context)
                .setView(dialogView)
                .create()

            // Bind RecyclerView di dalam dialog
            val recyclerView: RecyclerView = dialogView.findViewById(R.id.rvFormulirDropdown)
            recyclerView.adapter = DropdownAdapter(options) { selectedOption ->
                textView.text = selectedOption // Set teks yang dipilih
                dialog.dismiss() // Dismiss dialog setelah item dipilih
            }

            // Tampilkan dialog
            dialog.show()
        }
    }

    // ViewHolder untuk Input Field
    inner class InputFieldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val editText: EditText = itemView.findViewById(R.id.inputFomulirInput)

        fun bind(item: FormulirItem.InputField) {
            editText.hint = item.hint
        }
    }
}
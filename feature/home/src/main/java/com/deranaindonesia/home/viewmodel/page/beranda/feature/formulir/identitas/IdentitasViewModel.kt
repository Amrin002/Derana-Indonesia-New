package com.deranaindonesia.home.viewmodel.page.beranda.feature.formulir.identitas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deranaindonesia.home.data.beranda.formulir.FormulirItem

class IdentitasViewModel: ViewModel()  {
    private val _formulirItems = MutableLiveData<List<FormulirItem>>()
    val formulirItems: LiveData<List<FormulirItem>> get() = _formulirItems

    init {
        loadFormulirItems()
    }

    private fun loadFormulirItems() {
        _formulirItems.value = listOf(
            FormulirItem.Dropdown(
                label = "Jenis Kelamin",
                options = listOf("Laki-Laki", "Perempuan")
            ),
            FormulirItem.InputField(
                hint = "Nama Panjang"
            ),
            FormulirItem.Dropdown(
                label = "Pendidikan Terakhir",
                options = listOf("SD", "SMP", "SMA", "Diploma", "Sarjana", "Magister", "Doktor")
            )
        )
    }
}
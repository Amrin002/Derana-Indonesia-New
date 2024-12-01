package com.deranaindonesia.home.viewmodel.page.beranda

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deranaindonesia.home.data.beranda.DataBelajar
import com.deranaindonesia.ui.R

class BerandaViewModel : ViewModel() {
    private val _belajarItems = MutableLiveData<List<DataBelajar>>()
    val belajarItems: LiveData<List<DataBelajar>> get() = _belajarItems

    init {
        // Inisialisasi data dummy
        _belajarItems.value = listOf(
            DataBelajar(
                "Belajar\nBahasa Buru",
                "Episode 1",
                R.drawable.belajar1,
                50,
                Color.parseColor("#3CCAFD")
            ),
            DataBelajar(
                "Belajar\nBahasa Alune",
                "Episode 2",
                R.drawable.belajar2,
                70,
                Color.parseColor("#DF1995")
            ),
            DataBelajar(
                "Belajar\nBahasa Yatoke",
                "Episode 3",
                R.drawable.belajar3,
                30,
                Color.parseColor("#F06400")
            )
        )
    }
}
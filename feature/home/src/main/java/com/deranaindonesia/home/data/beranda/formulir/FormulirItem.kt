package com.deranaindonesia.home.data.beranda.formulir

sealed class FormulirItem {
    data class Dropdown(val label: String, val options: List<String>) : FormulirItem()
    data class InputField(val hint: String) : FormulirItem()

}
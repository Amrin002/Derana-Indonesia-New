package com.deranaindonesia.home.data.beranda.formulir

data class PertanyaanFormulir(
    val id: Int,
    val teksPertanyaan: String,
    val type: QuestionType
)

enum class QuestionType {
    INPUT, DROPDOWN
}

package com.deranaindonesia.home.data.beranda.feature

interface DataItem {
    val iconRes: Int
    val namaProduk: String
}

data class DataProduk(
    override val iconRes: Int,
    override val namaProduk: String
) : DataItem

data class DataPengetahuan(
    override val iconRes: Int,
    override val namaProduk: String
) : DataItem

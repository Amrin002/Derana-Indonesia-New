package com.deranaindonesia.home.ui.page.beranda.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.deranaindonesia.home.data.beranda.feature.DataItem
import com.deranaindonesia.home.data.beranda.feature.DataPengetahuan
import com.deranaindonesia.home.data.beranda.feature.DataProduk

import com.deranaindonesia.home.ui.adapter.beranda.feature.AllfiturAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.deranaindonesia.ui.R
import com.deranaindonesia.ui.databinding.AllFiturBinding

class Allfitur: BottomSheetDialogFragment() {
    private var _binding: AllFiturBinding? = null
    private val binding get() = _binding!!
    private var isGrid = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AllFiturBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data Produk
        val fiturProduk = listOf(
            DataProduk(R.drawable.ar_bahasa, "AR \nBahasa"),
            DataProduk(R.drawable.statistik_bahasa, "Statistik\nBahasa"),
            DataProduk(R.drawable.kartu_bahasa, "Kartu\nBahasa")
        )

        // Data Pengetahuan
        val fiturPengetahuan = listOf(
            DataPengetahuan(R.drawable.kekerabatan_bahasa, "Kekerabatan\nBahasa"),
            DataPengetahuan(R.drawable.kosakata_swedesh, "Kosakata\nSwedesh")
        )

        val produkAdapter = AllfiturAdapter(fiturProduk)
        binding.rvProduk.layoutManager = GridLayoutManager(context, 3)
        binding.rvProduk.adapter = produkAdapter

        val pengetahuanAdapter = AllfiturAdapter(fiturPengetahuan)
        binding.rvPengetahuan.layoutManager = GridLayoutManager(context, 3)
        binding.rvPengetahuan.adapter = pengetahuanAdapter

        binding.icGridView.setOnClickListener {
            if (!isGrid) {
                binding.rvProduk.layoutManager = GridLayoutManager(context, 3)
                binding.rvPengetahuan.layoutManager = GridLayoutManager(context, 3)
                isGrid = true
                updateViewMode(isGrid)
            }
        }

        binding.icLinearView.setOnClickListener {
            if (isGrid) {
                binding.rvProduk.layoutManager = LinearLayoutManager(context)
                binding.rvPengetahuan.layoutManager = LinearLayoutManager(context)
                isGrid = false
                updateViewMode(isGrid)
            }
        }
    }
    private fun updateViewMode(isGrid: Boolean) {
        if (isGrid) {
            binding.icGridView.setBackgroundResource(R.drawable.ic_grid_selector)
            binding.icGridView.setColorFilter(
                ContextCompat.getColor(requireContext(), R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            binding.icLinearView.setBackgroundResource(R.drawable.ic_linear_selector)
            binding.icLinearView.clearColorFilter()
        } else {
            binding.icGridView.setBackgroundResource(R.drawable.ic_grid_selector)
            binding.icGridView.clearColorFilter()
            binding.icLinearView.setBackgroundResource(R.drawable.ic_linear_selector)
            binding.icLinearView.setColorFilter(
                ContextCompat.getColor(requireContext(), R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

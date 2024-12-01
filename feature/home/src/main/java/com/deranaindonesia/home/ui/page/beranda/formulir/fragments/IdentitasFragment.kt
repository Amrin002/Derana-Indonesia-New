package com.deranaindonesia.home.ui.page.beranda.formulir.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.deranaindonesia.home.R
import com.deranaindonesia.home.databinding.FragmentIdentitasBinding
import com.deranaindonesia.home.ui.adapter.beranda.formulir.identitas.IdentitasFormulirAdapter
import com.deranaindonesia.home.viewmodel.page.beranda.feature.formulir.identitas.IdentitasViewModel


class IdentitasFragment : Fragment() {
    private var _binding: FragmentIdentitasBinding? = null
    private val binding get() = _binding!!

    // Deklarasi ViewModel
    private val viewModel: IdentitasViewModel by viewModels()

    // Adapter untuk RecyclerView
    private lateinit var adapter: IdentitasFormulirAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIdentitasBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inisialisasi RecyclerView
        binding.rvIdentitas.layoutManager = LinearLayoutManager(requireContext())

        // Observasi data dari ViewModel
        viewModel.formulirItems.observe(viewLifecycleOwner) { items ->
            adapter = IdentitasFormulirAdapter(items)
            binding.rvIdentitas.adapter = adapter
        }
    }

}
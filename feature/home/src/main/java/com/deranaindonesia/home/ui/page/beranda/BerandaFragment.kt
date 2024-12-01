package com.deranaindonesia.home.ui.page.beranda

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deranaindonesia.home.databinding.FragmentBerandaBinding
import com.deranaindonesia.home.ui.adapter.beranda.BelajarAdapter
import com.deranaindonesia.home.ui.page.beranda.feature.Allfitur
import com.deranaindonesia.home.ui.page.beranda.feature.formulir.FormulirActivity
import com.deranaindonesia.home.viewmodel.page.beranda.BerandaViewModel

class BerandaFragment : Fragment() {
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = BerandaFragment()
    }

    private val viewModel: BerandaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BelajarAdapter(emptyList())
        binding.rvBelajar.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.rvBelajar.adapter = adapter

        // Observasi data dari ViewModel
        viewModel.belajarItems.observe(viewLifecycleOwner) { items ->
            adapter.updateData(items)
        }
        // Binding View lainnya disini

        binding.formulir.setOnClickListener {
            val intent = Intent(requireContext(), FormulirActivity::class.java )
            startActivity(intent)
        }

        binding.BtnLainnya.setOnClickListener{
            val bottomSheetLainnya = Allfitur()
            bottomSheetLainnya.show(parentFragmentManager, "AllFiturBottomSheetFragment")
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
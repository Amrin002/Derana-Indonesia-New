package com.deranaindonesia.home.ui.page.belajar

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deranaindonesia.home.R
import com.deranaindonesia.home.databinding.FragmentBelajarBinding
import com.deranaindonesia.home.viewmodel.page.belajar.BelajarViewModel

class BelajarFragment : Fragment() {
    private var _binding: FragmentBelajarBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = BelajarFragment()
    }

    private val viewModel: BelajarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBelajarBinding.inflate(inflater, container, false)
        return binding.root
    }
}
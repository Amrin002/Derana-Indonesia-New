package com.deranaindonesia.home.ui.page.temukan

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deranaindonesia.home.R
import com.deranaindonesia.home.databinding.FragmentTemukanBinding
import com.deranaindonesia.home.viewmodel.page.temukan.TemukanViewModel

class TemukanFragment : Fragment() {
    private var _binding: FragmentTemukanBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = TemukanFragment()
    }

    private val viewModel: TemukanViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTemukanBinding.inflate(inflater, container, false)
        return binding.root
    }
}
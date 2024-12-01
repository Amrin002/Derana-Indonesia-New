package com.deranaindonesia.auth.ui.login.fragments.register

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.deranaindonesia.auth.R
import com.deranaindonesia.auth.databinding.FragmentRegisterBinding
import com.deranaindonesia.auth.viewmodel.login.fragments.register.RegisterViewModel

class RegisterFragment : Fragment() {
    private val viewModel: RegisterViewModel by viewModels()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterBinding.bind(view)

        //observasi live data dari view model
        viewModel.isLoading.observe(viewLifecycleOwner){ isLoading ->
            binding.btnRegister.isEnabled = !isLoading
        }

        viewModel.isError.observe(viewLifecycleOwner){ message ->
            if (!message.isNullOrEmpty()){
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                viewModel.resetErrorMessage()
            }
        }

        viewModel.isSuccess.observe(viewLifecycleOwner){ isSuccess ->
            if (isSuccess){
                Toast.makeText(requireContext(), "Register berhasil", Toast.LENGTH_SHORT).show()
                // arahkan ke halaman login
            }
        }
        binding.btnRegister.setOnClickListener {
            val namaLengkap = binding.etNama.text.toString()
            val nomorTelp = binding.etNomor.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.register(namaLengkap, nomorTelp, email, password)
        }


    }
}
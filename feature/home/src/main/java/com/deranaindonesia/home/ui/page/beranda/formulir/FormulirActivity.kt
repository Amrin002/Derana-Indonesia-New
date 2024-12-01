package com.deranaindonesia.home.ui.page.beranda.feature.formulir

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.deranaindonesia.home.R
import com.deranaindonesia.home.databinding.ActivityFormulirBinding
import com.deranaindonesia.home.ui.MainScreensActivity
import com.deranaindonesia.home.ui.adapter.beranda.formulir.FormulirPagerAdapter
import com.deranaindonesia.home.ui.page.beranda.BerandaFragment
import com.deranaindonesia.home.viewmodel.page.beranda.feature.formulir.FormulirViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FormulirActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormulirBinding
    // view model
    private val viewModel: FormulirViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFormulirBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backButton.setOnClickListener{
            val intent = Intent(this, MainScreensActivity::class.java)
            startActivity(intent)
            finish()
        }
        val adapter = FormulirPagerAdapter(this)
        binding.vpFormulir.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.vpFormulir){ tab, position ->
            tab.text = when (position){
                0 -> "Identitas"
                1 -> "Kondisi Bahasa"
                2 -> "Kosakata"
                else -> null
            }
        }.attach()
    }
}
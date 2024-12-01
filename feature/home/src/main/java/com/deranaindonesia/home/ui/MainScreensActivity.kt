package com.deranaindonesia.home.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.deranaindonesia.home.R
import com.deranaindonesia.home.databinding.ActivityMainScreensBinding
import com.deranaindonesia.home.ui.page.belajar.BelajarFragment
import com.deranaindonesia.home.ui.page.beranda.BerandaFragment
import com.deranaindonesia.home.ui.page.chat.ChatFragment
import com.deranaindonesia.home.ui.page.temukan.TemukanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainScreensActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainScreensBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainScreensBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottomNavigation: BottomNavigationView =binding.bottomNav

        bottomNavigation.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when(item.itemId) {
                R.id.berandaPage -> selectedFragment = BerandaFragment()
                R.id.belajarPage -> selectedFragment = BelajarFragment()
                R.id.temukanPage -> selectedFragment = TemukanFragment()
                R.id.chatPage -> selectedFragment = ChatFragment()
            }
            if (selectedFragment != null){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fcvMain, selectedFragment)
                    .commit()
            }
            true

        }
        if(savedInstanceState == null){
            bottomNavigation.selectedItemId = R.id.berandaPage
        }
    }
}
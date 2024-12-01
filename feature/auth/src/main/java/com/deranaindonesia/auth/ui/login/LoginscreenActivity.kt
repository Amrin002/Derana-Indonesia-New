package com.deranaindonesia.auth.ui.login

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.deranaindonesia.auth.R
import com.deranaindonesia.auth.databinding.ActivityLoginscreenBinding
import com.deranaindonesia.auth.ui.login.fragments.login.LoginFragment
import com.deranaindonesia.auth.ui.login.fragments.register.RegisterFragment


class LoginscreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Set default fragment to LoginFragment
        replaceFragment(LoginFragment())

        // Handle tab button clicks
        binding.tabMasuk.setOnClickListener {
            replaceFragment(LoginFragment())
            updateTabState(true)
        }

        binding.tabDaftar.setOnClickListener {
            replaceFragment(RegisterFragment())
            updateTabState(false)
        }

        //term and privacy
        val text = "Dengan masuk atau mendaftar, kamu menyetujui Ketentuan Layanan dan Kebijakan Privasi."
        val spannable = SpannableString(text)

        val termStart = text.indexOf("Ketentuan Layanan")
        val termsEnd = termStart + "Ketentuan Layanan".length
        spannable.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
                Toast.makeText(this@LoginscreenActivity, "Ketentuan Layanan", Toast.LENGTH_SHORT).show()
            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }

        }, termStart, termsEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val privaciStart = text.indexOf("Kebijakan Privasi")
        val privacyEnd = privaciStart + "Kebijakan Privasi".length
        spannable.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
                Toast.makeText(this@LoginscreenActivity, "Kebijakan Privasi", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }

        }, privaciStart, privacyEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.termsAndPrivacy.text = spannable
        binding.termsAndPrivacy.movementMethod = LinkMovementMethod.getInstance()
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameregisterandlogin, fragment)
            .commit()
    }

    private fun updateTabState(isLoginSelected: Boolean) {
        if (isLoginSelected) {
            binding.tabMasuk.setBackgroundResource(com.deranaindonesia.ui.R.drawable.rounded_tab_login)
            binding.tabDaftar.setBackgroundColor(resources.getColor(android.R.color.transparent))
            binding.textLogin.setText("Masukkan Akunmu \nSekarang")
        } else {
            binding.tabMasuk.setBackgroundColor(resources.getColor(android.R.color.transparent))
            binding.tabDaftar.setBackgroundResource(com.deranaindonesia.ui.R.drawable.rounded_tab_login)
            binding.textLogin.setText("Daftarkan Akunmu \nSekarang")
        }
    }

    }

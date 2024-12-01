package com.deranaindonesia.auth.ui.getstarted

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.deranaindonesia.auth.R
import com.deranaindonesia.auth.databinding.ActivityGetStartedBinding
import com.deranaindonesia.auth.ui.login.LoginscreenActivity
import com.deranaindonesia.home.ui.MainScreensActivity

class GetStartedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var viewPager: ViewPager2
    private val handler = Handler(Looper.getMainLooper())
    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            val itemCount = viewPager.adapter?.itemCount ?: 0
            val nextItem = (viewPager.currentItem + 1) % itemCount
            viewPager.setCurrentItem(nextItem, true)
            handler.postDelayed(this, 3000)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewPager = binding.vpGetStarted
        val layouts = listOf(
            R.layout.get_started_1,
            R.layout.get_started_2,
            R.layout.get_started_3
        )

        val adapter = SliderPagerAdapter(layouts)
        viewPager.adapter = adapter

        handler.postDelayed(autoScrollRunnable, 5000)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicators(position)
            }
        })

        binding.loginFacebook.setOnClickListener{
            startActivity(Intent(this, MainScreensActivity::class.java))
        }
        binding.Register.setOnClickListener{
            startActivity(Intent(this, LoginscreenActivity::class.java))
            finish()
        }

        updateIndicators(0)
    }



    private fun updateIndicators(position: Int) {
        val indicators = listOf(
            binding.vp1, binding.vp2, binding.vp3)
        indicators.forEachIndexed{ index, imageView ->
            if (index == position) {
                imageView.setColorFilter(resources.getColor(com.deranaindonesia.ui.R.color.primaryColor, null))
            }else{
                imageView.setColorFilter(resources.getColor(com.deranaindonesia.ui.R.color.gray, null))
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(autoScrollRunnable)
    }




}

class SliderPagerAdapter(private val layouts: List<Int>) : RecyclerView.Adapter<SliderPagerAdapter.SliderViewHolder>(){
    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
//        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = layouts.size

    override fun getItemViewType(position: Int): Int = layouts[position]


}
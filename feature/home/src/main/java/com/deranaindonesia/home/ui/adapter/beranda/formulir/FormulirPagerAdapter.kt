package com.deranaindonesia.home.ui.adapter.beranda.formulir

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.deranaindonesia.home.ui.page.beranda.feature.formulir.FormulirActivity
import com.deranaindonesia.home.ui.page.beranda.formulir.fragments.IdentitasFragment
import com.deranaindonesia.home.ui.page.beranda.formulir.fragments.KondisibahasaFragment
import com.deranaindonesia.home.ui.page.beranda.formulir.fragments.KosakataFragment

class FormulirPagerAdapter(activity: FormulirActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> IdentitasFragment()
            1 -> KondisibahasaFragment()
            2 -> KosakataFragment()
            else -> throw IllegalStateException("Unexpected postion: $position")
        }
    }

}
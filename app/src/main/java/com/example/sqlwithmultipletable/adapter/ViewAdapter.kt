package com.example.sqlwithmultipletable.adapter

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sqlwithmultipletable.fragment.CarsFragment
import com.example.sqlwithmultipletable.fragment.FootballFragment
import com.example.sqlwithmultipletable.fragment.ProgrammingFragment

class ViewAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CarsFragment()
            1 -> FootballFragment()
            2 -> ProgrammingFragment()
            else -> Fragment()
        }
    }

    override fun saveState(): Parcelable? {
        return null
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Car"
            1 -> "Football"
            2 -> "Programming"
            else -> ""
        }
    }
}
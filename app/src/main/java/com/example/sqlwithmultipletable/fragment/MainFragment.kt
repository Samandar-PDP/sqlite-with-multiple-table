package com.example.sqlwithmultipletable.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.sqlwithmultipletable.R
import com.example.sqlwithmultipletable.adapter.ViewAdapter
import com.example.sqlwithmultipletable.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        val viewPagerAdapter = ViewAdapter(childFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.isSaveEnabled = false

        binding.viewPager.adapter = viewPagerAdapter
    }
}
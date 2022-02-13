package com.example.worldskillsprep2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.worldskillsprep2022.databinding.FragmentSecondBinding
import com.google.android.material.tabs.TabLayoutMediator


class SecondFragment : Fragment() {

    private lateinit var binding:  FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        with(binding) {

            viewPager.adapter = FragmentAdapter(requireParentFragment())

            TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                tab.text = "Tab ${position + 1} "
            }.attach()

        }
        return binding.root
    }

    class FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> Tab1Fragment()
                1 -> tab2Fragment()
                2 -> tab3Fragment()
                else -> Tab1Fragment()
            }
        }

    }

}
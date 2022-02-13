package com.example.worldskillsprep2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.worldskillsprep2022.adapter.UnsplashAdapter
import com.example.worldskillsprep2022.databinding.FragmentFirstBinding
import com.example.worldskillsprep2022.viewModel.MainViewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val adapter by lazy { UnsplashAdapter() }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)

        binding.rvUnsplash.adapter = adapter
        viewModel.getPhotos("cats")
        viewModel.myResponse.observe(viewLifecycleOwner){ response ->
            if (response.isSuccessful){
                response.body()?.let { adapter.submitList(it.results) }
            }
            else{
                Toast.makeText(requireActivity(), response.code(), Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }


}
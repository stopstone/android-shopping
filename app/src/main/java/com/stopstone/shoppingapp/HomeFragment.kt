package com.stopstone.shoppingapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stopstone.shoppingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()

        val assetLoader = AssetLoader()
        val result = assetLoader.loadAsset(requireContext(), "home.json")
        Log.d("HomeFragment", "result: $result")
    }

    private fun setLayout() {
        binding.viewpagerHomeBanner.adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
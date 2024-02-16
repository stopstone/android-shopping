package com.stopstone.shoppingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.stopstone.shoppingapp.R
import com.stopstone.shoppingapp.data.AssetLoader
import com.stopstone.shoppingapp.data.HomeRepository
import com.stopstone.shoppingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ProductClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var assetLoader: AssetLoader
    private val bannerAdapter = HomeBannerAdapter(this)
    private val repository: HomeRepository by lazy { HomeRepository(assetLoader) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assetLoader = AssetLoader(requireContext().assets)
    }

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
    }

    private fun setLayout() {
        setBanners()
        loadData()
    }

    private fun setBanners() {
        with(binding.viewpagerHomeBanner) {
            adapter = bannerAdapter

            val screenWidth = resources.displayMetrics.widthPixels
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)

            val offset = screenWidth - pageWidth - pageMargin
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            offscreenPageLimit = 2

            TabLayoutMediator(
                binding.viewpagerHomeBannerIndicator,
                this
            ) { _, _ -> }.attach()

        }
    }


    private fun loadData() {
        repository.getBannerJsonData()?.let {
            bannerAdapter.submitList(it.banners)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProductClick() {
        val action = HomeFragmentDirections.actionNavigationToProductDetail()
        findNavController().navigate(action)
    }
}
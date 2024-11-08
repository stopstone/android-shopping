package com.stopstone.shoppingapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.stopstone.shoppingapp.R
import com.stopstone.shoppingapp.data.source.asset.AssetLoader
import com.stopstone.shoppingapp.data.source.HomeRepository
import com.stopstone.shoppingapp.data.source.remote.ShoppingService
import com.stopstone.shoppingapp.databinding.FragmentHomeBinding
import com.stopstone.shoppingapp.ui.ProductClickListener
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), ProductClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var assetLoader: AssetLoader
    private val repository: HomeRepository by lazy { HomeRepository(ShoppingService.create()) }
    private val bannerAdapter = HomeBannerAdapter(this)


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
        lifecycleScope.launch {
            val homeData = repository.getBannerJsonData()
            bannerAdapter.submitList(homeData.banners)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProductClick(productId: String) {
        val action = HomeFragmentDirections.actionNavigationToProductDetail(productId)
        findNavController().navigate(action)
    }
}
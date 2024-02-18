package com.stopstone.shoppingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.stopstone.shoppingapp.R
import com.stopstone.shoppingapp.data.AssetLoader
import com.stopstone.shoppingapp.data.ProductDetailRepository
import com.stopstone.shoppingapp.databinding.FragmentProductDetailBinding
import com.stopstone.shoppingapp.ui.extension.applyNumberFormat
import com.stopstone.shoppingapp.ui.extension.applyNumberStrikeStyleFormat

class ProductDetailFragment: Fragment() {

    private var _binding : FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ProductDetailFragmentArgs by navArgs()
    private lateinit var assetLoader: AssetLoader
    private val repository: ProductDetailRepository by lazy { ProductDetailRepository(assetLoader) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assetLoader = AssetLoader(requireContext().assets)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productId = args.productId
        val product = repository.getProduct(productId)

        if (product != null) {
            with(binding) {
                tvProductDetailBrandName.text = product.brandName
                tvProductRating.text = product.rating.toString()
                tvProductDetailLabel.text = product.itemName
                tvProductDetailDiscountRate.text = getString(R.string.format_discount_unit, product.discountRate)
                tvProductDetailDiscountPrice.applyNumberFormat(product.discountPrice)
                tvProductDetailPrice.applyNumberStrikeStyleFormat(product.price)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
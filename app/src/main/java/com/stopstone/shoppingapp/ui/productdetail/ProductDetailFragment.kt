package com.stopstone.shoppingapp.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.stopstone.shoppingapp.R
import com.stopstone.shoppingapp.data.source.ProductDetailRepository
import com.stopstone.shoppingapp.data.source.remote.ShoppingService
import com.stopstone.shoppingapp.databinding.FragmentProductDetailBinding
import com.stopstone.shoppingapp.ui.extension.applyNumberFormat
import com.stopstone.shoppingapp.ui.extension.applyNumberStrikeStyleFormat
import kotlinx.coroutines.launch

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ProductDetailFragmentArgs by navArgs()
    private val repository: ProductDetailRepository by lazy {
        ProductDetailRepository(
            ShoppingService.create()
        )
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
        setLayout()
    }

    private fun setLayout() {
        val productId = args.productId
        lifecycleScope.launch {
            val product = repository.getProduct(productId)
            with(binding) {
                tvProductDetailBrandName.text = product.brandName
                tvProductRating.text = product.rating.toString()
                tvProductDetailLabel.text = product.itemName
                tvProductDetailDiscountRate.text =
                    getString(R.string.format_discount_unit, product.discountRate)
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
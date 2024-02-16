package com.stopstone.shoppingapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stopstone.shoppingapp.data.model.Banner
import com.stopstone.shoppingapp.databinding.ItemHomeBannerBinding

class HomeBannerAdapter : RecyclerView.Adapter<HomeBannerAdapter.HomeBannerViewHolder>() {

    private val banners = mutableListOf<Banner>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        return HomeBannerViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(banners[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun add(items: List<Banner>) {
        banners.addAll(items)
        notifyDataSetChanged()
    }

    class HomeBannerViewHolder private constructor(private val binding: ItemHomeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            val product = banner.product
            with(binding) {
                tvBannerBadge.text = banner.badge.label
                tvBannerTitle.text = banner.headLine
                tvBannerProductDetailBrandName.text = product.brandName
                tvBannerProductDetailLabel.text = product.itemName
                tvBannerProductDetailDiscountRate.text = product.discountRate.toString()
                tvBannerProductDetailPrice.text = product.price.toString()
            }
        }

        companion object {
            fun from(parent: ViewGroup): HomeBannerViewHolder {
                val binding = ItemHomeBannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return HomeBannerViewHolder(binding)
            }
        }

    }
}
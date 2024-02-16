package com.stopstone.shoppingapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stopstone.shoppingapp.data.model.Banner
import com.stopstone.shoppingapp.databinding.ItemHomeBannerBinding

class HomeBannerAdapter :
    ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        return HomeBannerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeBannerViewHolder private constructor(private val binding: ItemHomeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            val product = banner.product
            with(binding) {
                tvBannerBadge.text = banner.badge.label
                tvBannerBadge.setBackgroundColor(Color.parseColor(banner.badge.backgroundColor))
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

class BannerDiffCallBack : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}
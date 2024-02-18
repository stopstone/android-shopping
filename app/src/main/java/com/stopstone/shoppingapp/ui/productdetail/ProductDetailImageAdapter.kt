package com.stopstone.shoppingapp.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stopstone.shoppingapp.data.model.ProductDetailImage
import com.stopstone.shoppingapp.databinding.ItemProductDetailImageBinding
import com.stopstone.shoppingapp.ui.extension.load

class ProductDetailImageAdapter :
    ListAdapter<ProductDetailImage, ProductDetailImageAdapter.ProductDetailImageViewHolder>(
        ProductDetailImageDiffCallBack()
    ) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailImageViewHolder {
        return ProductDetailImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductDetailImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ProductDetailImageViewHolder(private val binding: ItemProductDetailImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductDetailImage) {
            binding.ivProductDetailImage.load(item.imgUrl)
        }

        companion object {
            fun from(parent: ViewGroup): ProductDetailImageViewHolder {
                val binding = ItemProductDetailImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ProductDetailImageViewHolder(binding)
            }
        }
    }
}

class ProductDetailImageDiffCallBack : DiffUtil.ItemCallback<ProductDetailImage>() {
    override fun areItemsTheSame(
        oldItem: ProductDetailImage,
        newItem: ProductDetailImage
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductDetailImage,
        newItem: ProductDetailImage
    ): Boolean {
        return oldItem == newItem
    }

}
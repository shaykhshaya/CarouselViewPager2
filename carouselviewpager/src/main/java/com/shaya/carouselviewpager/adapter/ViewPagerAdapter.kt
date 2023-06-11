package com.shaya.carouselviewpager.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shaya.carouselviewpager.databinding.ItemSliderBinding
import com.shaya.carouselviewpager.model.ImageEntity
import com.shaya.carouselviewpager.utils.Carousel
import com.shaya.carouselviewpager.utils.toPx

class ViewPagerAdapter(
    private val mImageEntityList: MutableList<ImageEntity>
) : RecyclerView.Adapter<ViewPagerAdapter.SliderViewHolder>() {

    class SliderViewHolder(val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: ImageEntity) {
            binding.ivSlider.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        with(holder) {
            with(mImageEntityList[position]) {

                Carousel.cornerRadius?.let {
                    binding.ivSlider.shapeAppearanceModel = binding.ivSlider.shapeAppearanceModel
                        .toBuilder()
                        .setAllCorners(Carousel.cornerFamily, it.toPx.toFloat())
                        .build()
                }

                Carousel.cornerRadiusTopLeft?.let {
                    binding.ivSlider.shapeAppearanceModel = binding.ivSlider.shapeAppearanceModel
                        .toBuilder()
                        .setTopLeftCorner(Carousel.cornerFamilyTopLeft, it.toPx.toFloat())
                        .build()
                }
                Carousel.cornerRadiusTopRight?.let {
                    binding.ivSlider.shapeAppearanceModel = binding.ivSlider.shapeAppearanceModel
                        .toBuilder()
                        .setTopRightCorner(Carousel.cornerFamilyTopRight, it.toPx.toFloat())
                        .build()
                }
                Carousel.cornerRadiusBottomLeft?.let {
                    binding.ivSlider.shapeAppearanceModel = binding.ivSlider.shapeAppearanceModel
                        .toBuilder()
                        .setBottomLeftCorner(Carousel.cornerFamilyBottomLeft, it.toPx.toFloat())
                        .build()
                }
                Carousel.cornerRadiusBottomRight?.let {
                    binding.ivSlider.shapeAppearanceModel = binding.ivSlider.shapeAppearanceModel
                        .toBuilder()
                        .setBottomRightCorner(Carousel.cornerFamilyBottomRight, it.toPx.toFloat())
                        .build()
                }

                bind(this)
                binding.ivSlider.setOnClickListener {
                    Carousel.imageClicked?.invoke(this)
                }
            }
        }
    }

    override fun getItemCount() = mImageEntityList.size


}
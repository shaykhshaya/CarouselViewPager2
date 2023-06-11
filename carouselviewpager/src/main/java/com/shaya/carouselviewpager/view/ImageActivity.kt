package com.shaya.carouselviewpager.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.shaya.carouselviewpager.R
import com.shaya.carouselviewpager.adapter.ViewPagerAdapter
import com.shaya.carouselviewpager.databinding.ActivityImageBinding
import com.shaya.carouselviewpager.utils.*
import com.shaya.carouselviewpager.utils.Carousel.Companion.imageList
import com.shaya.carouselviewpager.utils.Carousel.Companion.timeInterval


class ImageActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, ImageActivity::class.java)
            context.startActivity(starter)
        }
    }

    private lateinit var binding: ActivityImageBinding
    private lateinit var sliderAdapter: ViewPagerAdapter
    private lateinit var itemDecoration: HorizontalMarginItemDecoration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.makeStatusBarTransparent()

        sliderAdapter = ViewPagerAdapter(mImageEntityList = imageList)


        itemDecoration = HorizontalMarginItemDecoration(
            this,
            Carousel.horizontalMargin?: R.dimen.viewpager_current_item_horizontal_margin
        )
        setupCarouselSlider()

    }



    private fun setupCarouselSlider() {
        binding.viewpager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            // setPageTransformer(GateTransformer())
            adapter = sliderAdapter
            setCarouselEffects()
            addItemDecoration(itemDecoration)
            autoScroll(lifecycleScope, timeInterval, Carousel.autoScrolls)
        }
    }


}
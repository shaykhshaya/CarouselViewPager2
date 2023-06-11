package com.shaya.samplecarousel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shaya.carouselviewpager.R
import com.shaya.carouselviewpager.adapter.ViewPagerAdapter
import com.shaya.carouselviewpager.model.ImageEntity
import com.shaya.carouselviewpager.utils.Carousel
import com.shaya.carouselviewpager.utils.makeStatusBarTransparent
import com.shaya.carouselviewpager.view.ImageActivity
import com.shaya.samplecarousel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.makeStatusBarTransparent()

        val imageList = arrayListOf<ImageEntity>(
        (ImageEntity(title = "image1", description = null, image = R.drawable.image1)),
        (ImageEntity(title = "image2", description = null, image = R.drawable.image2)),
        (ImageEntity(title = "image3", description = null, image = R.drawable.image3)),
        (ImageEntity(title = "image4", description = null, image = R.drawable.image4)),
        (ImageEntity(title = "image5", description = null, image = R.drawable.image5)),
        (ImageEntity(title = "image6", description = null, image = R.drawable.image6)),
        (ImageEntity(title = "image7", description = null, image = R.drawable.image7)),
        (ImageEntity(title = "image8", description = null, image = R.drawable.image8)),
        (ImageEntity(title = "image9", description = null, image = R.drawable.image9)))




       Carousel.with(this)
           .list(imageList)
           .timeInterval(1000L)
           .cornerFamilyTopRight(0)
           .cornerRadiusTopRight(100)
           .cornerFamilyBottomLeft(0)
           .cornerRadiusBottomLeft(100)
           .onItemClick {
               Toast.makeText(this, it?.title, Toast.LENGTH_SHORT).show()
           }
           .autoScroll(true)
           .alpha(0.7f)
           .start()
    }
}
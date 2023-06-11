package com.shaya.carouselviewpager.utils

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.viewpager2.widget.ViewPager2
import com.shaya.carouselviewpager.R
import kotlinx.coroutines.delay
import kotlin.math.abs



fun ViewPager2.autoScroll(lifecycleScope: LifecycleCoroutineScope, interval: Long, isAutoScrolls: Boolean? = true) {
    if(isAutoScrolls == true){
        lifecycleScope.launchWhenResumed {
            scrollIndefinitely(interval)
        }
    }

}

suspend fun ViewPager2.scrollIndefinitely(interval: Long) {
    delay(interval)
    val numberOfItems = adapter?.itemCount ?: 0
    val lastIndex = if (numberOfItems > 0) numberOfItems - 1 else 0
    val nextItem = if (currentItem == lastIndex) 0 else currentItem + 1
    setCurrentItem(nextItem, true)
    scrollIndefinitely(interval)
}


fun ViewPager2.setCarouselEffects(){
    offscreenPageLimit = 2

    //val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
    val nextItemVisiblePx = resources.getDimension(Carousel.offScreenItemVisibility?: R.dimen.viewpager_next_item_visible)


    //val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
    val currentItemHorizontalMarginPx = resources.getDimension(Carousel.horizontalMargin?: R.dimen.viewpager_current_item_horizontal_margin)

    val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
    val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
        page.translationX = -pageTranslationX * position
        page.scaleY = 1 - (0.25f * abs(position))
        page.alpha = /*0.5f*/(Carousel.alpha) + (1 - abs(position))

    }
    setPageTransformer(pageTransformer)
}

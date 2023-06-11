package com.shaya.carouselviewpager.utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class GateTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = -position*page.width;

        if (position<-1){
            page.alpha = 0f;

        }
        else if (position<=0){
            page.alpha = 1f;
            page.pivotX = 0f;
            page.rotationY = 90* abs(position);

        }
        else if (position <=1){
            page.alpha = 1f;
            page.pivotX = page.width.toFloat();
            page.rotationY = -90* abs(position);

        }else {
            page.alpha = 0f

        }

    }
}


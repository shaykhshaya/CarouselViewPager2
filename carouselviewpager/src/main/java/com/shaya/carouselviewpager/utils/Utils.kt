package com.shaya.carouselviewpager.utils

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.view.Window
import android.view.WindowManager

fun Window.makeStatusBarTransparent(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        val w: Window = this
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}

val Int.toPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

//fun Int.toDp(context: Context): Int = (this / context.resources.displayMetrics.density).toInt()

val Int.toDp: Int
get() = (this / Resources.getSystem().displayMetrics.density).toInt()
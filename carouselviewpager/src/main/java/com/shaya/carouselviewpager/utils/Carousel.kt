package com.shaya.carouselviewpager.utils

import android.content.Context
import android.content.res.Resources
import androidx.annotation.DimenRes
import com.shaya.carouselviewpager.R
import com.shaya.carouselviewpager.model.ImageEntity
import com.shaya.carouselviewpager.view.ImageActivity

class Carousel private constructor(
    private val mContext: Context,
    private val mList: ArrayList<ImageEntity>,
    private val mCornerRadius: Int?,
    private val mTimeInterval: Long = 5000L,
    private val mCornerRadiusTopLeft: Int?,
    private val mCornerRadiusTopRight: Int?,
    private val mCornerRadiusBottomLeft: Int?,
    private val mCornerRadiusBottomRight: Int?,
    private val mCorneFamilyTopLeft: Int = 0,
    private val mCornerFamilyBottomRight: Int = 0,
    private val mCornerFamilyTopRight: Int = 0,
    private val mCornerFamilyBottomLeft: Int = 0,
    private val mCornerFamily: Int = 0,
    private var mImageClicked: ((ImageEntity?) -> Unit)? = null,
    private var mHorizontalMargin: Int? = null,
    private var mOffScreenItemVisibility: Int? = null,
    private var mAlpha: Float = 0.0f,
    private var mAutoScrolls: Boolean = true
) {


    companion object {
        var timeInterval: Long = 5000L
        var imageList = arrayListOf<ImageEntity>()
        var cornerRadius: Int? = null
        var cornerRadiusTopLeft: Int? = null
        var cornerRadiusTopRight: Int? = null
        var cornerRadiusBottomLeft: Int? = null
        var cornerRadiusBottomRight: Int? = null
        var cornerFamilyTopLeft: Int = 0
        var cornerFamilyTopRight: Int = 0
        var cornerFamilyBottomLeft: Int = 0
        var cornerFamilyBottomRight: Int = 0
        var cornerFamily: Int = 0
        var imageClicked: ((ImageEntity?) -> Unit)? = null
        var horizontalMargin: Int? = R.dimen.viewpager_current_item_horizontal_margin
        var offScreenItemVisibility: Int? = R.dimen.viewpager_next_item_visible
        var alpha: Float = 0.0f
        var autoScrolls: Boolean = true

    }


    init {

        imageList = mList
        timeInterval = mTimeInterval
        cornerRadius = mCornerRadius
        cornerRadiusTopLeft = mCornerRadiusTopLeft
        cornerRadiusTopRight = mCornerRadiusTopRight
        cornerRadiusBottomLeft = mCornerRadiusBottomLeft
        cornerRadiusBottomRight = mCornerRadiusBottomRight
        cornerFamily = mCornerFamily
        cornerFamilyTopLeft = mCorneFamilyTopLeft
        cornerFamilyTopRight = mCornerFamilyTopRight
        cornerFamilyBottomLeft = mCornerFamilyBottomLeft
        cornerFamilyBottomRight = mCornerFamilyBottomRight
        imageClicked = mImageClicked
        horizontalMargin = mHorizontalMargin
        autoScrolls = mAutoScrolls
        offScreenItemVisibility = mOffScreenItemVisibility
        alpha = mAlpha

        ImageActivity.start(mContext)

    }


    class with(private val context: Context) {

        private var cornerRadius: Int? = null
        private var cornerRadiusTopLeft: Int? = null
        private var cornerRadiusTopRight: Int? = null
        private var cornerRadiusBottomLeft: Int? = null
        private var cornerRadiusBottomRight: Int? = null
        private var cornerFamilyTopLeft: Int = 0
        private var cornerFamilyTopRight: Int = 0
        private var cornerFamilyBottomLeft: Int = 0
        private var cornerFamilyBottomRight: Int = 0
        private var list: ArrayList<ImageEntity> = arrayListOf()
        private var timeInterval: Long = 5000L
        private var cornerFamily: Int = 0
        private var onItemClick: ((ImageEntity?) -> Unit)? = null
        private var horizontalMargin: Int? = null
        private var offScreenItemVisibility: Int? = null
        private var autoScrolls: Boolean = true
        private var alpha: Float = 0.5f

        /******************* CORNER RADIUS **************************/
        fun cornerRadius(radius: Int) = apply {
            this.cornerRadius = radius
        }

        fun cornerRadiusTopLeft(radius: Int) = apply {
            this.cornerRadiusTopLeft = radius
        }

        fun cornerRadiusTopRight(radius: Int) = apply {
            this.cornerRadiusTopRight = radius
        }

        fun cornerRadiusBottomLeft(radius: Int) = apply {
            this.cornerRadiusBottomLeft = radius
        }

        fun cornerRadiusBottomRight(radius: Int) = apply {
            this.cornerRadiusBottomRight = radius
        }


        /******************* IMAGE LIST *******************************/
        fun list(list: ArrayList<ImageEntity>) = apply {
            this.list = list
        }

        /******************* TIME INTERVAL *******************************/
        fun timeInterval(timeInterval: Long) = apply {
            this.timeInterval = timeInterval
        }

        /******************* CORNER FAMILY *******************************/
        fun cornerFamily(corner: Int) = apply {
            this.cornerFamily = corner
        }

        fun cornerFamilyTopLeft(cornerFamily: Int) = apply {
            this.cornerFamilyTopLeft = cornerFamily
        }

        fun cornerFamilyTopRight(cornerFamily: Int) = apply {
            this.cornerFamilyTopRight = cornerFamily
        }

        fun cornerFamilyBottomLeft(cornerFamily: Int) = apply {
            this.cornerFamilyBottomLeft = cornerFamily
        }

        fun cornerFamilyBottomRight(cornerFamily: Int) = apply {
            this.cornerFamilyBottomRight = cornerFamily
        }

        /******************* HANDLE CLICK *******************************/
        fun onItemClick(onClick: (ImageEntity?) -> Unit) = apply {
            this.onItemClick = onClick
        }

        /******************* HORIZONTAL MARGIN *******************************/
        fun horizontalMargin(@DimenRes margin: Int) = apply {
            this.horizontalMargin = margin
        }

        /******************* AUTO SCROLLS *******************************/
        fun autoScroll(scroll:Boolean) = apply {
            this.autoScrolls = scroll
        }

        /******************* OFF SCREEN ITEM VISIBILITY *******************************/
        fun offScreenItemVisibility(@DimenRes margin: Int) = apply {
            this.offScreenItemVisibility = margin
        }

        /******************* OFF SCREEN ITEM ALPHA *******************************/
        fun alpha(alpha: Float) = apply {
            this.alpha = alpha
        }


        fun start() = Carousel(
            mContext = context,
            mList = list,
            mCornerRadius = cornerRadius,
            mTimeInterval = timeInterval,
            mCornerRadiusTopLeft = cornerRadiusTopLeft,
            mCornerRadiusTopRight = cornerRadiusTopRight,
            mCornerRadiusBottomLeft = cornerRadiusBottomLeft,
            mCornerRadiusBottomRight = cornerRadiusBottomRight,
            mCornerFamily = cornerFamily,
            mCorneFamilyTopLeft = cornerFamilyTopLeft,
            mCornerFamilyTopRight = cornerFamilyTopRight,
            mCornerFamilyBottomLeft = cornerFamilyBottomLeft,
            mCornerFamilyBottomRight = cornerFamilyBottomRight,
            mImageClicked = onItemClick,
            mHorizontalMargin = horizontalMargin,
            mAutoScrolls = autoScrolls,
            mOffScreenItemVisibility = offScreenItemVisibility,
            mAlpha = alpha

        )


    }


}
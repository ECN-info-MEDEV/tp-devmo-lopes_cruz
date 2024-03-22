package com.example.brainmatch.ui

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.imageview.ShapeableImageView

class SquareImageView : ShapeableImageView {

    constructor(context: Context) :
            super(context)

    constructor(context: Context, attrs: AttributeSet) :
            super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec) // Crop the image to make a square
    }
}
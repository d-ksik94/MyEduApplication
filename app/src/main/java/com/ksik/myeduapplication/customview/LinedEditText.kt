package com.ksik.myeduapplication.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import com.ksik.myeduapplication.R

class LinedEditText(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(
        context!!, attrs
    ) {

    private var mRect: Rect? = null
    private var mPaint: Paint? = null

    init {
        paint?.style = Paint.Style.STROKE
        paint?.color = 0x800000FF.toInt()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        val count = lineCount
        val r = mRect
        val paint = mPaint

        for ( i in 0 until count){
            val baseline = getLineBounds(i,r)

            r?.left?.let {
                paint?.let { it1 ->
                    canvas?.drawLine(it.toFloat(),
                        (baseline+1).toFloat(), r.right.toFloat(), (baseline+1).toFloat(), it1
                    )
                }
            }
        }
        super.onDraw(canvas)
    }

}
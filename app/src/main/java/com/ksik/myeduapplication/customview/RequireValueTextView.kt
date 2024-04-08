package com.ksik.myeduapplication.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Range
import android.widget.TextView
import com.ksik.myeduapplication.R


/**
 * SalesNote
 * Created by ksik(river.h)
 * Date: 2023.08.30
 * Comment : 필수값을 표시하는 TextView를 text가 끝나는 지점에 붙이고자 만든 뷰.
 */
@SuppressLint("AppCompatCustomView")
class RequireValueTextView : TextView {
    //텍스트뷰 옆에 필수값 표시여부
    private var isRequireValue = false

    //필수값 표시 컬러
    private var requireValueColor = 0

    //필수값 표시 점 크기
    private var requireValueDotSize = 0f

    //필수값 표시 점 전체 margin
    private var requireValueDotMargin:Int ?=null


    private val paint: Paint by lazy { Paint().apply { color = requireValueColor } }
    private val textLineWidth: Rect by lazy {
        Rect().apply {
            this@RequireValueTextView.getPaint().getTextBounds(text.toString(), 0, text.length, this)
        }
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        setUp(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defRef: Int) : super(context, attributeSet, defRef) {
        setUp(attributeSet)
    }

    private fun setUp(attributeSet: AttributeSet) {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.RequireValueTextView,
            0, 0
        ).apply {

            try {

                for (i in 0..this.indexCount) {
                    val attr = this.getIndex(i)
                    when (attr) {
                        R.styleable.RequireValueTextView_requireValue -> setIsRequireValue(getBoolean(attr, false))
                        R.styleable.RequireValueTextView_requireValueColor -> setRequireValueColor(getColor(attr, resources.getColor(R.color.red_error, context.theme)))
                        R.styleable.RequireValueTextView_requireValueDotSize -> setRequireValueDotSize(getFloat(attr, 8.0f))
                        R.styleable.RequireValueTextView_requireValueDotMargin -> setRequireValueDotMargin(getDimensionPixelSize(attr, 0))
                    }
                }
            } finally {
                recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    fun setIsRequireValue(require: Boolean) {
        isRequireValue = require
        requestLayout()
        invalidate()
    }

    fun setRequireValueColor(color: Int) {
        requireValueColor = color
        requestLayout()
        invalidate()
    }

    fun setRequireValueDotSize(size: Float) {
        requireValueDotSize = size
        requestLayout()
        invalidate()
    }

    fun setRequireValueDotMargin(margin: Int) {
        requireValueDotMargin = margin
        requestLayout()
        invalidate()
    }

    fun setRequireValueDotMarginStart(margin: Int) {
        requireValueDotMargin = margin
        requestLayout()
        invalidate()
    }

    fun setRequireValueDotMarginEnd(margin: Int) {
        requireValueDotMargin = margin
        requestLayout()
        invalidate()
    }

    fun setRequireValueDotMarginTop(margin: Int) {
        requireValueDotMargin = margin
        requestLayout()
        invalidate()
    }

    fun setRequireValueDotMarginBottom(margin: Int) {
        requireValueDotMargin = margin
        requestLayout()
        invalidate()
    }
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        if (isRequireValue && text.isNotEmpty()) {
            val textLineEndWidth = textLineWidth.width().toFloat() + textSize
            val textViewVerticalCenter = bottom.toFloat() / 2
            canvas.drawCircle(textLineEndWidth, textViewVerticalCenter, requireValueDotSize, paint)
        }
        super.onDraw(canvas)
    }

    enum class DotMargin{
        MARGIN_START,
        MARGIN_END,
        MARGIN_TOP,
        MARGIN_BOTTOM
    }
//    companion object{
//        const val MARGIN_START = "START"
//        const val MARGIN_END = "END"
//        const val MARGIN_TOP = "TOP"
//        const val MARGIN_BOTTOM = "BOTTOM"
//    }
}
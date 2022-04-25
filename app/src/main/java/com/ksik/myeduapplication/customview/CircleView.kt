package com.ksik.myeduapplication.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.ksik.myeduapplication.R
import java.nio.charset.Charset

class CircleView
@SuppressLint("Recycle") constructor(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) { // 커스텀 속성을 참조하기 위한 변수
    private var myShapeColor: Int? = null // 생성자1: 코드에서 View 객체를 생성할 때 주로 호출
    private var myText: String? = null // 생성자2: 코드에서 View 객체를 생성할 때 주로 호출
    private var myTextColor: Int? = null // 생성자3: 코드에서 View 객체를 생성할 때 주로 호출
    private var myTextSize: Float? = null // 생성자3: 코드에서 View 객체를 생성할 때 주로 호출

    init {
        if (attrs != null && context != null) {
            // attr.xml파일 declare-styleable이 CustomView로 정의된 attr(속성)을 typeArray객체로 받아온다.
            val typedArr = context.obtainStyledAttributes(attrs, R.styleable.CircleView)
            // format을 구분하여 속성값 참조
            myShapeColor = typedArr.getColor(R.styleable.CircleView_myShapeColor, Color.YELLOW)
            myTextColor = typedArr.getColor(R.styleable.CircleView_myTextColor, Color.BLACK)
            myText = typedArr.getString(R.styleable.CircleView_myTextString)
            myTextSize = typedArr.getDimension(R.styleable.CircleView_myTextSize, 10f)
            typedArr.recycle()
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

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        // attr.xml 에서 참조해온 속성값을 적용
        val width = width
        val height = height
        var cx = width / 10.toFloat()
        var cy = height / 10.toFloat()
        val radi = 50f
        for (i in 0..4) {
            paint.color = myShapeColor ?: Color.BLACK
            for (j in 0..1) {
                canvas?.drawCircle(cx, cy, radi, paint)
                cy += height / 14

                paint.color = myTextColor ?: Color.BLACK
                paint.textSize = myTextSize ?: 10f
                myText?.let { canvas?.drawText(it, cx + 300, cy, paint) }
            }
            canvas?.drawCircle(cx, cy, radi, paint)
            cx += width / 5
        }

    }
}

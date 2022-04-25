package com.ksik.myeduapplication.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.ksik.myeduapplication.R

class PieChart
@SuppressLint("Recycle") constructor(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) { // 커스텀 속성을 참조하기 위한 변수
    private var myShapeColor: Int? = null // 생성자1: 코드에서 View 객체를 생성할 때 주로 호출

    init {
        if (attrs != null && context != null) {
// attr.xml파일 declare-styleable이 CustomView로 정의된 attr(속성)을 typeArray객체로 받아온다.
            val typedArr = context.obtainStyledAttributes(attrs, R.styleable.PieChart)
// format을 구분하여 속성값 참조
            myShapeColor = typedArr.getColor(R.styleable.PieChart_myShapeColor, Color.YELLOW)

            typedArr.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        Log.d("ksik", "onMeasure >> width : $width // height : $height")
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
        paint.color = myShapeColor ?: Color.BLACK
        val width = width
        val height = height
        Log.d("ksik", "onDraw >> width : $width // height : $height")
        var cx = width / 10.toFloat()
        var cy = height / 10.toFloat()
        val radi = 50f
        for (i in 0..4) {
            for (j in 0..1) {
                canvas?.drawCircle(cx, cy, radi, paint)
                cy += height / 14

            }
            canvas?.drawCircle(cx, cy, radi, paint)
            cx += width / 5
        }
    }
}

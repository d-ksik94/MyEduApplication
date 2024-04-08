package com.ksik.myeduapplication.customview

import android.content.Context
import android.print.PrintAttributes.Margins
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import com.ksik.myeduapplication.R
import com.ksik.myeduapplication.databinding.LayoutCommonTitleContentBinding


/**
 * SalesNote
 * Created by ksik(river.h)
 * Date: 2023.08.30
 * Comment :
 */
class CommonTitleLayout : LinearLayout {
    private lateinit var _binding: LayoutCommonTitleContentBinding
    private val binding get() = _binding

//    private var requireValueTextview: RequireValueTextView? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        setUp(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defRef: Int) : super(context, attributeSet, defRef) {
        setUp(attributeSet)
    }

    private fun setUp(attributeSet: AttributeSet) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        _binding = LayoutCommonTitleContentBinding.inflate(inflater, this, true)
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CommonTitleLayout,
            0, 0
        ).apply {
            try {
                for (i in 0..indexCount) {
                    when (val attr = getIndex(i)) {
                        R.styleable.CommonTitleLayout_title -> setTitle(getString(attr))
                        R.styleable.CommonTitleLayout_layoutRequireValue -> setIsRequireValue(getBoolean(attr, false))
                        R.styleable.CommonTitleLayout_layoutRequireValueColor -> setRequireValueColor(getColor(attr, resources.getColor(R.color.red_error, context.theme)))
                        R.styleable.CommonTitleLayout_layoutRequireValueDotSize -> setRequireValueDotSize(getFloat(attr, 8.0f))
                    }
                }
            } finally {
                recycle()
            }
        }

    }

    fun setTitle(title: String?) {
        title?.let {
            binding.requireValueTextview.text = title
        }
    }

    fun setIsRequireValue(require: Boolean) {
        binding.requireValueTextview.setIsRequireValue(require)
    }

    fun setRequireValueColor(color: Int) {
        binding.requireValueTextview.setRequireValueColor(color)
    }

    fun setRequireValueDotSize(size: Float) {
        binding.requireValueTextview.setRequireValueDotSize(size)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}
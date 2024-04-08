package com.ksik.myeduapplication.customview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Html
import android.util.AttributeSet
import android.util.Patterns
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.util.LinkifyCompat
import java.util.regex.Pattern

/**
 * SalesNote
 * Created by ksik(river.h)
 * Date: 2023.08.22
 * Comment :
 * 안드로이드 자체에서 제공해주는 autoLink에서 Phone부분이 정상 동작하지 않아 관련 커스텀 뷰를 만듦.
 * 기존 : phone설정후 010-0000-0000 (안됨) -> +82-10-0000-0000(됨)
 * 이 뷰를 사용할때는 XML에서 autoLink옵션을 제거한다.
 */
class AutoLinkTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        setUp()
    }

    constructor(context: Context, attributeSet: AttributeSet, defRef: Int) : super(context, attributeSet, defRef) {
        setUp()
    }

    private fun setUp() {
        //addLinks함수는 자체적으로 scheme에서 scheme.toLowerCase()를 실행한다.
        LinkifyCompat.addLinks(this, Patterns.PHONE, "tel://")
        LinkifyCompat.addLinks(this, Patterns.EMAIL_ADDRESS, "mailto:")
        LinkifyCompat.addLinks(this, Patterns.WEB_URL, "")
    }

    override fun setText(inputText: CharSequence?, type: BufferType?) {
        var inputString = inputText.toString()
        val matcher = Pattern.compile(PATTERN_HTML).matcher(inputString)
        if (matcher.find()) {
            val hrefLinkify = getAHrefLinkify(inputString)
            if (!hrefLinkify.isNullOrEmpty()) {
                // spannable을 생성합니다.
//                val spannable = SpannableString(inputString)
                this.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hrefLinkify))
                    context.startActivity(intent)
                }
                // 링크를 찾습니다.
                /*Regex(PATTERN_HTML).findAll(inputString).forEach { tag ->
                    // 링크의 URL을 가져옵니다.
                    val href = tag.groups.find { it?.value?.contains("href") == true }?.value?.split("=")?.get(1)?.replace(">","")

                    // 링크의 시작 위치와 끝 위치를 찾습니다.
                    val start = tag.range.first
                    val end = tag.range.last

                    // spannable에 링크를 설정합니다.
                    if(href == hrefLinkify){
                        spannable.setSpan(object : ClickableSpan() {
                            override fun onClick(widget: View) {
                                // 링크의 URL을 가져와 웹 브라우저로 이동합니다.
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(href))
                                context.startActivity(intent)
                            }
                        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                }*/

                // spannable을 TextView에 설정합니다.
//                this.text = spannable.toString()
            }
            super.setText(Html.fromHtml(inputString, Html.FROM_HTML_MODE_COMPACT), type)
        } else {
            super.setText(inputText, type)
        }
    }

    private fun getAHrefLinkify(inputString: String): String? {
        val allTagRegex = Regex(PATTERN_HTML)
        var resultUrl: String? = null
        allTagRegex.findAll(inputString).forEach { tag ->
            if (tag.groups.any { it?.value?.contains("href") == true }) {
                // URL 부분만 반환
                resultUrl = tag.groups.find { it?.value?.contains("href") == true }?.value?.split("=")?.get(1)?.replace(">", "")
            }
        }
        return resultUrl
    }

    companion object {
        const val PATTERN_HTML = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>"
    }
}
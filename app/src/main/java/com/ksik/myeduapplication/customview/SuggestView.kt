package com.ksik.myeduapplication.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.get


/**
 * SalesNote
 * Created by ksik(river.h)
 * Date: 2023.08.16
 * Comment :
 * 기획 미확정으로 검색창이 어디에 들어갈지 몰라 커스텀뷰로 만들었음.
 * 확정 후 필요없다 싶으면 아래 내용을 응용하여 각 프래그먼트에 AppCompatAutoCompleteTextView를 사용하여 직접 구현하여도 됨.
 */
class SuggestView(context: Context, attrs: AttributeSet?) : AppCompatAutoCompleteTextView(context, attrs) {

    private var urlPath: String? = null

//    private val viewModel by lazy {
//        val viewModelStoreOwner = checkNotNull(findViewTreeViewModelStoreOwner())
//        ViewModelProvider(viewModelStoreOwner).get<SuggestViewModel>()
//    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        //이 뷰를 관리하는 라이프사이클 소유자를 찾아와 생명주기에 맞춰 기능처리
        findViewTreeLifecycleOwner()?.lifecycle?.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)
                //suggest목록을 옵저빙하여 리스트로 뿌려준다.
                /*viewModel.suggestListData.observe(owner) {
                    setAdapter(ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, it))
                    showDropDown()
                }
                addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        if (s.toString().isEmpty()) dismissDropDown()
                        else viewModel.getSuggestList(s.toString(), urlPath)

                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    }
                }
                )*/
            }
        })
    }

    /*
    * 여기서 받은 url을 viewmodel에 넘길 예정
    * API로 쓸것같다고 해서 만들어 놓음.(화면마다 가져오는 주소가 다를수도 있다고 생각)
    * 추후 필요없으면 삭제
    * */
    fun setUrlPath(url: String) {
        urlPath = url
    }
}
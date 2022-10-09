package com.studio.lib_common.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import com.studio.lib_common.R


class ClearEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    @SuppressLint("UseCompatLoadingForDrawables")
    private var clearDrawable: Drawable =
        resources.getDrawable(R.drawable.common_icon_clear)

    @SuppressLint("UseCompatLoadingForDrawables")
    private var searchDrawable: Drawable =
        resources.getDrawable(R.drawable.common_icon_search)


    init {
        setCompoundDrawablesWithIntrinsicBounds(
            searchDrawable, null,
            null, null
        )
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)

        if (text?.length!! > 0) {
            setCompoundDrawablesWithIntrinsicBounds(
                searchDrawable, null,
                clearDrawable, null
            )
        } else {
            setCompoundDrawablesWithIntrinsicBounds(
                searchDrawable, null,
                null, null
            )
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_UP -> {
                var drawable: Drawable = clearDrawable
                if (event.x <= (width - paddingRight)
                    && event.x >= (width - paddingRight - drawable.bounds.width())
                ) {
                    setText("")
                }

            }
        }

        return super.onTouchEvent(event)
    }


}
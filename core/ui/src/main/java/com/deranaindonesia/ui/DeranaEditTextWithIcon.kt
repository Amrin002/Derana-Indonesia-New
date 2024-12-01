package com.deranaindonesia.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputLayout
import java.util.jar.Attributes

class DeranaEditTextWithIcon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val iconView: ImageView
    private val lyInput: TextInputLayout
    private val inputEditText: EditText

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.edit_text_withicon, this, true)

        iconView = view.findViewById(R.id.leadingIcon)
        lyInput = view.findViewById(R.id.inputLayout)
        inputEditText = view.findViewById(R.id.etInput)

        // Extract custom attributes
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.DeranaEditTextWithIcon, 0, 0)

            val icon = typedArray.getDrawable(R.styleable.DeranaEditTextWithIcon_leadingIcon)
            val label = typedArray.getString(R.styleable.DeranaEditTextWithIcon_labelText)
            val placeholder = typedArray.getString(R.styleable.DeranaEditTextWithIcon_placeholderText)
            val inputType = typedArray.getInt(R.styleable.DeranaEditTextWithIcon_android_inputType, InputType.TYPE_CLASS_TEXT)

            icon?.let { setLeadingIcon(it) }
            setLabel(label ?: "")
            setPlaceholder(placeholder ?: "")
            setInputType(inputType)

            typedArray.recycle()
        }
    }

    fun setLeadingIcon(drawable: Drawable) {
        iconView.setImageDrawable(drawable)
    }

    fun setLabel(label: String) {
        lyInput.hint = label
    }

    fun setPlaceholder(placeholder: String) {
        inputEditText.hint = placeholder
    }

    fun setInputType(inputType: Int) {
        inputEditText.inputType = inputType
    }

    fun getInputValue(): String {
        return inputEditText.text.toString()
    }

    fun setInputValue(value: String) {
        inputEditText.setText(value)
    }
}
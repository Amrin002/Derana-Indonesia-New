package com.deranaindonesia.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.imageview.ShapeableImageView

class DeranaButtonWithLabel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): RelativeLayout(context, attrs, defStyleAttr) {

    private val icon: ShapeableImageView
    private val label: AppCompatTextView

    init {
        LayoutInflater.from(context).inflate(R.layout.button_fitur, this, true)
        icon = findViewById(R.id.imgIcon)
        label = findViewById(R.id.tvLabel)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DeranaButtonWithLabel)
        icon.setImageResource(attributes.getResourceId(R.styleable.DeranaButtonWithLabel_icon, 0))
        label.text = attributes.getString(R.styleable.DeranaButtonWithLabel_label)
        attributes.recycle()
    }
    fun setIcon(resourcesId : Int){
        icon.setImageResource(resourcesId)
    }
    fun setLabel(text : String){
        label.text = text

    }
}
package com.kirvigen.delegateadapter

import android.content.Context
import android.graphics.Color
import android.view.View
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_image.*
import java.util.*

class ColorViewHolder: DelegateHolder {
    constructor(context: Context):super(context)
    constructor(view: View):super(view)

    var onClick:OnClickListenerHolderColor? = null

    init { try { onClick =  (containerView.context as OnClickListenerHolderColor) }catch (e: Exception){ } }

    interface  OnClickListenerHolderColor{
        fun onClick(i:ColorObj)
    }

    init {
        classObject = ColorObj::class.java
        layoutId = R.layout.item_image
    }

    override fun bind(o: Any) {
        val  colorObj = o as ColorObj
        colorView.setCardBackgroundColor(colorObj.color)
        colorView.setOnClickListener { onClick?.onClick(colorObj) }
    }
}
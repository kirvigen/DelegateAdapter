package com.kirvigen.delegateadapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_image.*
import java.lang.Exception

class ColorViewHolder: DelegateHolder {
    constructor(context: Context):super(context)
    constructor(view: View):super(view)
    init { try { onClick =  (containerView.context as OnClickListenerHolderColor) }catch (e: Exception){ } }
    var onClick:OnClickListenerHolderColor? = null
    interface  OnClickListenerHolderColor{
        fun onClick(i:String)
    }

    override fun createHolder(parent: ViewGroup): DelegateHolder {
        return ColorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
    }

    override fun getTypeItem(): Class<String>{
        return String::class.java
    }

    override fun bind(o: Any) {
        val  obj = o as String
        colorView.setBackgroundColor(Color.parseColor(obj))
        colorView.setOnClickListener { onClick?.onClick(obj) }
    }
}
package com.kirvigen.delegateadapter

import android.content.Context
import android.view.View
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_text.*

class TextViewHolder:DelegateHolder {
    constructor(context: Context):super(context)
    constructor(view: View):super(view)

    init {
        classObject = TextObj::class.java
        layoutId = R.layout.item_text
    }

    override fun bind(item: Any) {
        val textObj = item as TextObj
        TextView.text = textObj.text
    }
}
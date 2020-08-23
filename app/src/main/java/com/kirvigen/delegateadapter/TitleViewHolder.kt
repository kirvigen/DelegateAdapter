package com.kirvigen.delegateadapter

import android.content.Context
import android.view.View
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_title.*

class TitleViewHolder: DelegateHolder{
    constructor(context:Context):super(context)
    constructor(view:View):super(view)
    init {
        classObject = TitleObj::class.java
        layoutId = R.layout.item_title
    }

    override fun bind(item: Any?) {
        val  obj = item as TitleObj
        titleView.text = obj.title
    }
}


package com.kirvigen.delegateadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_title.*
import java.lang.reflect.Type

class TitleViewHolder: DelegateHolder{
    constructor(context:Context):super(context)
    constructor(view:View):super(view)
    init {
        classObject = TitleObj::class.java
        layoutId = R.layout.item_title
    }

    override fun bind(o: Any) {
        val  obj = o as TitleObj
        titleView.text = obj.title
    }
}


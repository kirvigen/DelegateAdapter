package com.kirvigen.delegateadapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.reflect.TypeToken
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_text.*
import java.lang.reflect.Type
import java.util.*
import kotlin.reflect.safeCast

class TitleViewHolder: DelegateHolder{
    constructor(view:Context):super(view)
    constructor(view:View):super(view)

    override fun getLayoutId(): Int {
        return R.layout.item_text
    }

    override fun getTypeItem(): Type {
        return object : TypeToken<TitleObj>(){}.type
    }

    override fun bind(o: Any) {
        val  obj = o as TitleObj
        textView.text = obj.title
    }


}


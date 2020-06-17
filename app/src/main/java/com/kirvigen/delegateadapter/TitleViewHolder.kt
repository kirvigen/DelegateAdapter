package com.kirvigen.delegateadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirvigen.delegateadapterlibrary.DelegateHolder
import kotlinx.android.synthetic.main.item_text.*
import java.lang.Exception

class TitleViewHolder: DelegateHolder {
    constructor(context:Context):super(context)
    constructor(view:View):super(view)

    init { try { onClick =  (containerView.context as OnClickListenerMyHolder) }catch (e:Exception){ } }
    var onClick:OnClickListenerMyHolder? = null
    interface  OnClickListenerMyHolder{
        fun onClick(i:TitleObj)
    }
    override fun createHolder(parent: ViewGroup): DelegateHolder {
        return TitleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
    }

    override fun getTypeItem(): Class<TitleObj>{
        return TitleObj::class.java
    }

    override fun bind(o: Any) {
        val  obj = o as TitleObj
        textView.text = obj.title
        textView.setOnClickListener {
            onClick?.onClick(obj)
        }
    }

}
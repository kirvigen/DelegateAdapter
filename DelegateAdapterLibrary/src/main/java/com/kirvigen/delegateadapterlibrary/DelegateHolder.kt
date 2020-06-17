package com.kirvigen.delegateadapterlibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

open class DelegateHolder:RecyclerView.ViewHolder,LayoutContainer,DHolder {

    constructor(context: Context):super(LayoutInflater.from(context).inflate(android.R.layout.list_content, null, false)){
               val v = TextView(itemView.context)
            containerView = LayoutInflater.from(context).inflate(android.R.layout.list_content, null, false)
    }
    constructor(v:View):super(v){
        containerView = v
    }

    override fun createHolder(parent: ViewGroup): DelegateHolder {
        TODO("Not yet implemented")
    }

    override fun getTypeItem(): Any{
        TODO("Not yet implemented")
    }

    override fun bind(item:Any){
        TODO("Not yet implemented")
    }

    override lateinit var containerView: View

}
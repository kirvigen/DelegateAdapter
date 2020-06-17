package com.kirvigen.delegateadapterlibrary

import android.view.View
import android.view.ViewGroup

interface DHolder {
    fun createHolder(parent: ViewGroup):DelegateHolder
    fun getTypeItem():Any
    fun bind(item:Any)
}
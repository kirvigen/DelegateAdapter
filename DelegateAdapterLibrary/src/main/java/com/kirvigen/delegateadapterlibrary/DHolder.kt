package com.kirvigen.delegateadapterlibrary

import android.view.View
import android.view.ViewGroup
import java.lang.reflect.Type
import kotlin.reflect.KClass

interface DHolder {
    fun getLayoutId():Int
    fun createHolder(parent: ViewGroup):DelegateHolder
    fun bind(item:Any)
    fun getTypeItem():Type
}
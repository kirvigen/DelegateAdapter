package com.kirvigen.delegateadapterlibrary

import java.lang.reflect.Type
import kotlin.reflect.KClass

class DelegateManager(
    var data:MutableList<Any> = mutableListOf()
) {
    val viewHolders = mutableListOf<Class<DelegateHolder>>()
    val idsLayout = mutableListOf<Int>()
    val types = mutableListOf<Type>()
    fun addHolder(h:DelegateHolder):DelegateManager{
        idsLayout.add(h.getLayoutId())
        types.add(h.getTypeItem())
        viewHolders.add(h::class.java as Class<DelegateHolder>)
        return this
    }
    fun build():AdapterDelegate{
        return AdapterDelegate(this)
    }
}
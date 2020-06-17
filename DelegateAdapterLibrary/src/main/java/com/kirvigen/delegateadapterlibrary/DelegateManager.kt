package com.kirvigen.delegateadapterlibrary

class DelegateManager(
    var data:MutableList<Any> = mutableListOf()
) {
    val viewHolders = mutableListOf<DelegateHolder>()
    fun addHolder(h:DelegateHolder):DelegateManager{
        viewHolders.add(h)
        return this
    }
    fun build():AdapterDelegate{
        return AdapterDelegate(this)
    }
}
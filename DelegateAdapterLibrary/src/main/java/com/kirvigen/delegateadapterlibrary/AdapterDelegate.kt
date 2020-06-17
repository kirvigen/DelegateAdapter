package com.kirvigen.delegateadapterlibrary

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterDelegate(val manager:DelegateManager): RecyclerView.Adapter<DelegateHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DelegateHolder {
         return manager.viewHolders[viewType].createHolder(parent)
    }

    override fun getItemViewType(position: Int): Int {
         for(i in 0 until manager.viewHolders.size)
             if(manager.data[position]::class.java == manager.viewHolders[i].getTypeItem() )
                 return i
         return 1
    }

    override fun getItemCount(): Int {
        return manager.data.size
    }

    override fun onBindViewHolder(holder: DelegateHolder, position: Int) {
         holder.bind(manager.data.get(position))
    }
}
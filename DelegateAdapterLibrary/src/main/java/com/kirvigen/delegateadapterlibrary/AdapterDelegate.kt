package com.kirvigen.delegateadapterlibrary

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.internal.`$Gson$Types`
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AdapterDelegate(val manager:DelegateManager): RecyclerView.Adapter<DelegateHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DelegateHolder {

        val c = manager.viewHolders[viewType]

        return c.constructors.last().newInstance(LayoutInflater.from(parent.context).inflate(manager.idsLayout[viewType],
            parent, false)) as DelegateHolder
    }

    override fun getItemViewType(position: Int): Int {
        val t = TypeToken.get(manager.data[position]::class.java).type
        for(i in 0 until manager.viewHolders.size) {
            if (t == manager.types[i])
                return i
        }
        return 0
    }

    override fun getItemCount(): Int {
        return manager.data.size
    }

    override fun onBindViewHolder(holder: DelegateHolder, position: Int) {
         holder.bind(manager.data.get(position))
    }
}
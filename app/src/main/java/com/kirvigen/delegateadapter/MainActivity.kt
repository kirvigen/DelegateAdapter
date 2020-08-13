package com.kirvigen.delegateadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirvigen.delegateadapterlibrary.DelegateManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ColorViewHolder.OnClickListenerHolderColor {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d = mutableListOf<Any>()
        d.add(TitleObj("Начало"))
        d.add("#FF0000")
        d.add("#FF7F00")
        d.add("#FFFF00")
        d.add("#00FF99")
        d.add("#0000FF")
        d.add("#4B0082")
        d.add("#8F00FF")
        d.add(TitleObj("TEXT END"))

        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val adapter = DelegateManager(d)
            .addHolder(TitleViewHolder(this))
            .addHolder(ColorViewHolder(this))
            .build()
        recycler.adapter = adapter
        d.add(TitleObj("END FULL"))
        adapter.notifyDataSetChanged()

    }


    override fun onClick(i: String) {
        Toast.makeText(this, "color: $i", Toast.LENGTH_SHORT).show()
    }
}
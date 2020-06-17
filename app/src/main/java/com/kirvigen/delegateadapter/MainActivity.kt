package com.kirvigen.delegateadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirvigen.delegateadapterlibrary.DelegateManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),TitleViewHolder.OnClickListenerMyHolder,ColorViewHolder.OnClickListenerHolderColor {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d = mutableListOf<Any>()
        for (i in 0 until 10)
            d.add(TitleObj("${i}) TEXT"))
        for (i in 0 until 10)
            d.add("#0${i}0${i}${i}0")
        d.add(TitleObj("TEXT END"))

        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycler.adapter = DelegateManager(d)
            .addHolder(TitleViewHolder(this))
            .addHolder(ColorViewHolder(this))
            .build()
    }

    override fun onClick(i: TitleObj) {
        Toast.makeText(this,i.title,Toast.LENGTH_LONG).show()
    }

    override fun onClick(i: String) {
        Toast.makeText(this, "color: $i", Toast.LENGTH_SHORT).show()
    }
}
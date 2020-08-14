package com.kirvigen.delegateadapter

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirvigen.delegateadapterlibrary.DelegateManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),ColorViewHolder.OnClickListenerHolderColor {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<Any>()
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
        val adapter = DelegateManager(data)
            .addHolder(TitleViewHolder(this))
            .addHolder(ColorViewHolder(this))
            .addHolder(TextViewHolder(this))
            .build()
        recycler.adapter = adapter

        AddText.setOnClickListener {
            data.add(TextObj(resources.getString(R.string.BigText)))
            adapter.notifyItemInserted(data.size)
            recycler.smoothScrollToPosition(data.size-1)
        }
        AddTitle.setOnClickListener {
            data.add(TitleObj("TestTitle"))
            adapter.notifyItemInserted(data.size)
            recycler.smoothScrollToPosition(data.size-1)
        }
        Addimage.setOnClickListener {
            val rnd = Random()
            val color = Color.argb(
                255,
                rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256)
            )
            data.add(ColorObj(color))
            adapter.notifyItemInserted(data.size)
            recycler.smoothScrollToPosition(data.size-1)
        }

    }


    override fun onClick(i: ColorObj) {
        Toast.makeText(this, "color: ${i.color}", Toast.LENGTH_SHORT).show()
    }
}
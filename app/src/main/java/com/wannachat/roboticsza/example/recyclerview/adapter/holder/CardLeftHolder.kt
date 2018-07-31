package com.wannachat.roboticsza.example.recyclerview.adapter.holder

import android.content.Context
import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wannachat.roboticsza.example.R

class CardLeftHolder : BaseViewHolder {
    private lateinit var image:ImageView
    private lateinit var content:TextView
    private var context:Context

    constructor(context:Context,itemView: View) : super(itemView) {
        setupView(itemView)
        this.context = context
    }

    private fun setupView(view:View){
        image = view.findViewById(R.id.image)
        content = view.findViewById(R.id.content)
    }

    fun setPicture(res: Int){
        image.setImageResource(res)
    }

    fun setPicture(url: String){
        if(url.isEmpty() || !URLUtil.isValidUrl(url)) return
        Glide.with(context).load(url).into(image)
    }

    fun setContent(strContent: String){
        content.text = strContent
    }


}
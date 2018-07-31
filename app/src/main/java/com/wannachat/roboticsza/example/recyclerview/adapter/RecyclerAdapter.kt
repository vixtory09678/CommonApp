package com.wannachat.roboticsza.example.recyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wannachat.roboticsza.example.R
import com.wannachat.roboticsza.example.recyclerview.adapter.holder.BaseViewHolder
import com.wannachat.roboticsza.example.recyclerview.adapter.holder.CardLeftHolder
import com.wannachat.roboticsza.example.recyclerview.adapter.holder.CardRightHolder
import com.wannachat.roboticsza.example.recyclerview.model.BaseItem
import com.wannachat.roboticsza.example.recyclerview.model.ItemCardLeft
import com.wannachat.roboticsza.example.recyclerview.model.ItemCardRight
import com.wannachat.roboticsza.example.recyclerview.model.ItemType

class RecyclerAdapter(private var context: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    private var mList:ArrayList<BaseItem>? = null

    fun setListItem(list: ArrayList<BaseItem>){
        mList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var v:View
        when(viewType){
            ItemType.TYPE_CARD_VIEW_LEFT -> {
                v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_one,parent,false)
                return CardLeftHolder(context,v)
            }
            ItemType.TYPE_CARD_VIEW_RIGHT -> {
                v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_two,parent,false)
                return CardRightHolder(context,v)
            }
        }
        throw Exception("type not match")
    }

    override fun getItemCount(): Int {
        if(mList == null) return 0
        return mList!!.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when(holder){
            is CardRightHolder -> {
                val itemCardRight = mList!![position] as ItemCardRight
                holder.setContent(itemCardRight.getContent())
                holder.setPicture(itemCardRight.getUrlPic())
            }

            is CardLeftHolder -> {
                val itemCardLeft = mList!![position] as ItemCardLeft
                holder.setContent(itemCardLeft.getContent())
                holder.setPicture(itemCardLeft.getUrlPic())
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return mList!![position]!!.getType()
    }
}
package com.wannachat.roboticsza.example.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.wannachat.roboticsza.example.R
import com.wannachat.roboticsza.example.recyclerview.adapter.RecyclerAdapter
import com.wannachat.roboticsza.example.recyclerview.model.BaseItem
import com.wannachat.roboticsza.example.recyclerview.model.ItemCardLeft
import com.wannachat.roboticsza.example.recyclerview.model.ItemCardRight
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    private lateinit var rvAdapter: RecyclerAdapter
    private lateinit var mListAdapter:ArrayList<BaseItem>
    private lateinit var rv:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        setupRecyclerView()
        setupButton()
    }

    private fun setupRecyclerView(){
        rv = findViewById(R.id.recycler)
        rv.layoutManager = LinearLayoutManager(this)
        rvAdapter = RecyclerAdapter(this)

        rv.adapter = rvAdapter


    }

    private fun setupButton(){
        btnLoadData.setOnClickListener {
            mListAdapter = getListAdapter()
            rvAdapter.setListItem(mListAdapter!!)

            rvAdapter.notifyDataSetChanged()
        }
    }

    private fun getListAdapter():ArrayList<BaseItem>{
        val list:ArrayList<BaseItem> = ArrayList()

        for(i in 1..20){
            if(i % 2 == 0){
                list.add(ItemCardLeft()
                        .setContent("hello world")
                        .setUrlPic("https://firebasestorage.googleapis.com/v0/b/forsample-a8a8f.appspot.com/o/Narutos_Sage_Mode.jpg?alt=media&token=ea632f4a-c4fc-434c-9220-155c5601bd74"))
            }else{
                list.add(ItemCardRight()
                        .setContent("hello world2")
                        .setUrlPic("https://firebasestorage.googleapis.com/v0/b/forsample-a8a8f.appspot.com/o/119790385.jpg?alt=media&token=915b0a99-c519-4b12-a759-cb57d6370d73"))
            }
        }
        return list
    }
}
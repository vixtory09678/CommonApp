package com.wannachat.roboticsza.example.pager

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.wannachat.roboticsza.example.R
import com.wannachat.roboticsza.example.pager.adapter.PagerController

class PagerActivity : AppCompatActivity() {

    private lateinit var pagerAdapter:PagerController
    private lateinit var pager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        setupPager()
    }

    private fun setupPager(){
        pager = findViewById(R.id.pager)
        setPagerAdapter()
    }

    private fun setPagerAdapter(){
        pagerAdapter = PagerController(supportFragmentManager)
        pager.adapter = pagerAdapter
    }

}
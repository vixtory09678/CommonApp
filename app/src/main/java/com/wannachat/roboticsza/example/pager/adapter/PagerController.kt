package com.wannachat.roboticsza.example.pager.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wannachat.roboticsza.example.pager.fragment.FragmentFour
import com.wannachat.roboticsza.example.pager.fragment.FragmentOne
import com.wannachat.roboticsza.example.pager.fragment.FragmentThree
import com.wannachat.roboticsza.example.pager.fragment.FragmentTwo

class PagerController(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val FRAGMENT_ONE = 0
    private val FRAGMENT_TWO = 1
    private val FRAGMENT_THREE = 2
    private val FRAGMENT_FOUR = 3

    private val FRAGMENT_NUM = 4

    override fun getItem(position: Int): Fragment {
        when(position){
            FRAGMENT_ONE    ->  return FragmentOne.getInstance()
            FRAGMENT_TWO    ->  return FragmentTwo.getInstance()
            FRAGMENT_THREE  ->  return FragmentThree.getInstance()
            FRAGMENT_FOUR   ->  return FragmentFour.getInstance()
        }
        throw Exception("fragment not found!")
    }

    override fun getCount(): Int {
        return FRAGMENT_NUM
    }
}
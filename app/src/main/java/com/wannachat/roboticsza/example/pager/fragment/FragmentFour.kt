package com.wannachat.roboticsza.example.pager.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wannachat.roboticsza.example.R

class FragmentFour : Fragment() {

    companion object {
        fun getInstance():FragmentFour{
            return FragmentFour()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_pager4, container , false)
        retainInstance = true

        return rootView
    }
}
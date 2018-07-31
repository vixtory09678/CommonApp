package com.wannachat.roboticsza.example.pager.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wannachat.roboticsza.example.R

class FragmentThree : Fragment() {

    companion object {
        fun getInstance():FragmentThree{
            return FragmentThree()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_pager3, container , false)
        retainInstance = true

        return rootView
    }
}
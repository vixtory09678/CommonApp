package com.wannachat.roboticsza.example.pager.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wannachat.roboticsza.example.R

class FragmentOne : Fragment() {

    companion object {
        fun getInstance():FragmentOne{
            return FragmentOne()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_pager1, container , false)
        retainInstance = true

        return rootView
    }
}
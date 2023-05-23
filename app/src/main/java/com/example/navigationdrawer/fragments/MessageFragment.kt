package com.example.navigationdrawer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.R

class MessageFragment :Fragment()  //extends from fragment super class
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.message_fragment,container,false)  //overriding the onCreateView
        //to return the fragment we created (inflater inflates the specific layout we made)
    }
}
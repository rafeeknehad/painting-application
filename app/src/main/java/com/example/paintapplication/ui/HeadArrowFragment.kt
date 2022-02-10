package com.example.paintapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.paintapplication.R

class HeadArrowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("rafeek", "onCreateView: 1")
        return inflater.inflate(R.layout.head_arrow_view, container, false)
    }
}
package com.example.paintapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.paintapplication.R

class SquareFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("rafeek", "onCreateView: 2")
        return inflater.inflate(R.layout.square_view, container, false)
    }
}
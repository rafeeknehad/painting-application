package com.example.paintapplication.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup


class PaintView : View {
    private var params: ViewGroup.LayoutParams? = null
    private val path = Path()
    private val brush = Paint()
    private lateinit var sharedPreferences: SharedPreferences


    constructor(context: Context) : this(context, null) {
        sharedPreferences =
            context.getSharedPreferences("Color", Context.MODE_PRIVATE)
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        sharedPreferences =
            context.getSharedPreferences("Color", Context.MODE_PRIVATE)
        drawFun()
    }

    private fun drawFun() {
        Log.d("rafeek", "drawFun: ")
        brush.isAntiAlias = true
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 8f
        brush.color = sharedPreferences.getInt("color", Color.BLACK)

        params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.x
        val y = event?.y

        return when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x!!, y!!)
                true
            }

            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x!!, y!!)
                true
            }

            else -> {
                false
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFun()
        canvas?.drawPath(path, brush)
        invalidate()
    }

}
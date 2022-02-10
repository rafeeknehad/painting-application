package com.example.paintapplication.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class SquareView : View {
    private var params: ViewGroup.LayoutParams? = null
    private val brush = Paint()
    private var firstX: Float? = 0f
    private var firstY: Float? = 0f
    private var lastX: Float? = 0f
    private var lastY: Float? = 0f
    private lateinit var sharedPreferences: SharedPreferences

    constructor(context: Context) : this(context, null) {}

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

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                firstX = x
                firstY = y
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                lastX = x
                lastY = y
                return true
            }

            else -> {
                return true
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFun()
        canvas?.drawRect(firstX!!, firstY!!, lastX!!, lastY!!, brush)
        invalidate()
    }

}
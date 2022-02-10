package com.example.paintapplication

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import com.example.paintapplication.ui.CircleFragment
import com.example.paintapplication.ui.HeadArrowFragment
import com.example.paintapplication.ui.PaintFragment
import com.example.paintapplication.ui.SquareFragment


class MainActivity : AppCompatActivity() {

    companion object {
        var color: Int = R.color.black
    }

    private lateinit var drawingBtn: ImageButton
    private lateinit var arrowBtn: ImageButton
    private lateinit var squareBtn: ImageButton
    private lateinit var circleBtn: ImageButton
    private lateinit var paintBtn: ImageButton
    private lateinit var parent: ConstraintLayout
    private lateinit var colors: LinearLayout
    private lateinit var redColor: ImageButton
    private lateinit var greenColor: ImageButton
    private lateinit var blueColor: ImageButton
    private lateinit var blackColor: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingBtn = findViewById(R.id.create_btn)
        arrowBtn = findViewById(R.id.arrow_btn)
        squareBtn = findViewById(R.id.square_btn)
        circleBtn = findViewById(R.id.circle_btn)
        paintBtn = findViewById(R.id.paint_btn)
        parent = findViewById(R.id.parent)
        colors = findViewById(R.id.linear2)
        redColor = findViewById(R.id.color_red)
        greenColor = findViewById(R.id.color_green)
        blueColor = findViewById(R.id.color_blue)
        blackColor = findViewById(R.id.color_black)

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences("Color", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        drawingBtn.setOnClickListener {
            resetBtn()
            drawingBtn.setBackgroundColor(resources.getColor(R.color.yellow))
            val paintFragment = PaintFragment()
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, paintFragment).commit()
        }

        arrowBtn.setOnClickListener {
            resetBtn()
            arrowBtn.setBackgroundColor(resources.getColor(R.color.yellow))
            val headArrowFragment = HeadArrowFragment()
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, headArrowFragment).commit()
        }

        squareBtn.setOnClickListener {
            resetBtn()
            squareBtn.setBackgroundColor(resources.getColor(R.color.yellow))
            val squareFragment = SquareFragment()
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, squareFragment).commit()
        }

        circleBtn.setOnClickListener {
            resetBtn()
            circleBtn.setBackgroundColor(resources.getColor(R.color.yellow))
            val circleFragment = CircleFragment()
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, circleFragment).commit()
        }

        paintBtn.setOnClickListener {
            resetBtn()
            paintBtn.setBackgroundColor(resources.getColor(R.color.yellow))
            colors.visibility = View.VISIBLE
        }

        redColor.setOnClickListener {
            color = Color.RED
            colors.visibility = View.GONE
            editor.putInt("color", Color.RED)
            editor.apply()
        }

        greenColor.setOnClickListener {
            color = Color.GREEN
            colors.visibility = View.GONE
            editor.putInt("color", Color.GREEN)
            editor.apply()
        }

        blueColor.setOnClickListener {
            color = Color.BLUE
            colors.visibility = View.GONE
            editor.putInt("color", Color.BLUE)
            editor.apply()
        }

        blackColor.setOnClickListener {
            color = Color.BLACK
            colors.visibility = View.GONE
            editor.putInt("color", Color.BLACK)
            editor.apply()
        }

    }

    private fun resetBtn() {
        drawingBtn.background = null
        arrowBtn.background = null
        squareBtn.background = null
        circleBtn.background = null
        paintBtn.background = null
    }
}

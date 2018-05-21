package com.example.folfo93.kotlinanimado

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.folfo93.kotlinanimado.R.layout.fragment_animation
import kotlinx.android.synthetic.main.fragment_animation.view.*

class AnimationActivity : AppCompatActivity() {

    protected lateinit var calendar: View
    protected lateinit var frameLayout: View
    protected var screenHeight = 10f

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_animation)

        calendar = findViewById(R.id.calendar)
        frameLayout = findViewById(R.id.fragmentAnimado)
        frameLayout.setOnClickListener { onStartAnimation() }
        onStartAnimation()
    }

    override fun onResume(){
        super.onResume()

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels.toFloat()
    }

    private fun onStartAnimation(){
        val valueAnimator = ValueAnimator.ofFloat(100f, -screenHeight)

        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            calendar.translationY = value
        }

        valueAnimator.interpolator = LinearInterpolator() as TimeInterpolator?
        valueAnimator.duration = Companion.DEFAULT_ANIMATION_DURATION

        valueAnimator.start()
    }

    companion object {
        val DEFAULT_ANIMATION_DURATION = 1700L
    }

}

package com.marcocastope.upnaveragecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMainAnimation()

    }

    private fun setupMainAnimation() {
        main_image.loadAnimation(this, R.animator.main_animations)
        main_title.loadAnimation(this, R.animator.title_animation)
        main_subtitle.loadAnimation(this, R.animator.subtitle_animation)
    }

}
package com.marcocastope.upnaveragecalculator

import android.animation.AnimatorInflater
import android.app.Activity
import android.view.View

fun View.loadAnimation(context: Activity, idAnim: Int) {
    val animation = AnimatorInflater.loadAnimator(context, idAnim)
    animation.setTarget(this)
    animation.start()
}


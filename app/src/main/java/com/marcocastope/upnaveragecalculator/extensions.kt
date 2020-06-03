package com.marcocastope.upnaveragecalculator

import android.animation.AnimatorInflater
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast

fun View.loadAnimation(context: Activity, idAnim: Int) {
    val animation = AnimatorInflater.loadAnimator(context, idAnim)
    animation.setTarget(this)
    animation.start()
}

inline fun <reified T : Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}


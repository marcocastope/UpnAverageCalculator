package com.marcocastope.upnaveragecalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_virtual_course.*
import kotlin.math.roundToInt

class VirtualCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virtual_course)
        setupClickListeners()
    }

    private fun calcProm(): Double? {
        val t1 = virtual_course_note1.text.toString()
        val t2 = virtual_course_note2.text.toString()
        val t3 = virtual_course_note3.text.toString()
        val t4 = virtual_course_note4.text.toString()
        val ef = virtual_course_note_final.text.toString()

        while (t1.isNotEmpty() && t2.isNotEmpty() && t3.isNotEmpty() && t4.isNotEmpty() && ef.isNotEmpty()) {
            return (t1.toInt() + t2.toInt() + t3.toInt() + t4.toInt()) * 0.15 + ef.toInt() * 0.4
        }
        return null
    }

    private fun showResults() {
        val result = calcProm()
        if (result != null) {
            virtual_course_results_wrapper.visibility = View.VISIBLE
            virtual_course_result_without_round.text = getString(R.string.number_format).format(result)
            virtual_course_result_with_round.text = result.roundToInt().toString()
        } else {
            toast("Todos los campos son requeridos")
        }
    }

    private fun setupClickListeners() {
        virtual_course_btn.setOnClickListener {
            it.loadAnimation(this, R.animator.btn_animation)
            showResults()
        }
    }
}

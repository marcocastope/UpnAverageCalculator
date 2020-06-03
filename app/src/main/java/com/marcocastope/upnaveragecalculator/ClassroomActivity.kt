package com.marcocastope.upnaveragecalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_classroom.*
import kotlin.math.roundToInt

class ClassroomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classroom)
        setupClickListeners()
    }

    private fun calcProm(): Double? {
        val n1 = classroom_note1.text.toString()
        val n2 = classroom_note2.text.toString()
        val ep = classroom_note_partial.text.toString()
        val ef = classroom_note_final.text.toString()

        while (n1.isNotEmpty() && n2.isNotEmpty() && ep.isNotEmpty() && ef.isNotEmpty()) {
            return (n1.toInt() + n2.toInt())*0.15 + ep.toInt()*0.3 + ef.toInt()*0.4
        }
        return null
    }
    
    private fun showResults() {
        val result = calcProm()
        if (result != null) {
            classroom_results_wrapper.visibility = View.VISIBLE
            classroom_result_without_round.text = "%.2f".format(result)
            classroom_result_with_round.text = result.roundToInt().toString()
        } else {
            toast("Todos los campos son requeridos")
        }
    }

    private fun setupClickListeners() {
        classroom_calc_btn.setOnClickListener { showResults() }
    }

}
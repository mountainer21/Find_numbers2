package com.example.findnumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.TextView
import com.example.findnumbers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 1

        binding.apply {
            val textViewList = mutableListOf<TextView>()

            fun game() {
                chronometer.base = SystemClock.elapsedRealtime()
                chronometer.start()
                count = 1
                textCount.text = count.toString()
                var numRand = MutableList(40) {  x -> "${x+1}" }

                textViewList.addAll(listOf(
                    textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10,
                    textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20,
                    textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30,
                    textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39, textView40
                ))

                var shList = numRand.shuffled()
                for (i in shList.indices)
                    textViewList[i].text = shList[i]
            }

            fun textViewClick (textView: TextView) {
                if (count.toString() == textView.text) {
                    textView.text = ""
                    count++
                    textCount.text = count.toString()
                    if (count == 41) {
                        chronometer.stop()
                        textCount.text = "DONE"
                        btnStart.text = "RESTART"
                    }
                }
            }

            game()

            btnStart.setOnClickListener {
                game()
            }

            textViewList.forEach { textView ->
                textView.setOnClickListener {
                    textViewClick(textView)
                }
            }
        }
    }
}
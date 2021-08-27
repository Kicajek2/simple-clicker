package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val text1 = findViewById<TextView>(R.id.text1)//score
        val text2 = findViewById<TextView>(R.id.text2)//time

        var score = 0
        var bonus = 0
        var time = 31

        val timer = object : CountDownTimer(30*1000, 1000 ) {
            override fun onFinish() {
                button1.isEnabled = false
                button2.isEnabled = false
                button3.isEnabled = false
                button4.isEnabled = false
                button5.isEnabled = false

                Toast.makeText(baseContext , "Koniec Gry" , Toast.LENGTH_LONG).show()
            }

            override fun onTick(millisUntilFinished: Long) {
                time -= 1
                text2.text = time.toString()
            }
        }

        button5.setOnClickListener {
            if(time == 31) {
                timer.start()
                time -= 1
            }
            score += 1 + bonus
            text1.text = score.toString()
        }

        button1.setOnClickListener {
            if (score >= 10){
                bonus += 1
                score -= 10
                text1.text = score.toString()
            }

        }

        button2.setOnClickListener {
            if (score >= 35){
                bonus += 3
                score -= 35
                text1.text = score.toString()
            }
        }

        button3.setOnClickListener {
            if (score >= 100){
                bonus += 7
                score -= 100
                text1.text = score.toString()
            }
        }

        button4.setOnClickListener {
            if (score >= 200){
                bonus += 12
                score -= 200
                text1.text = score.toString()
            }
        }

    }
}
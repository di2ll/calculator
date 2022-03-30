package com.example.education

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        var out: String = ""
        var temp: String = ""
        val input = findViewById<TextView>(R.id.input)
        val cache = findViewById<TextView>(R.id.temp)
        var sign: Int = 0
        // Numbers
        val one = findViewById<Button>(R.id.one).setOnClickListener{
            out+="1"
            input.text = out
            input.alpha = 1F
        }
        val two = findViewById<Button>(R.id.two).setOnClickListener{
            out+="2"
            input.text = out
            input.alpha = 1F
        }
        val three = findViewById<Button>(R.id.three).setOnClickListener{
            out+="3"
            input.text = out
            input.alpha = 1F
        }
        val four = findViewById<Button>(R.id.four).setOnClickListener{
            out+="4"
            input.text = out
            input.alpha = 1F
        }
        val five = findViewById<Button>(R.id.five).setOnClickListener{
            out+="5"
            input.text = out
            input.alpha = 1F
        }
        val six = findViewById<Button>(R.id.six).setOnClickListener{
            out+="6"
            input.text = out
            input.alpha = 1F
        }
        val seven = findViewById<Button>(R.id.seven).setOnClickListener{
            out+="7"
            input.text = out
            input.alpha = 1F
        }
        val eight = findViewById<Button>(R.id.eight).setOnClickListener{
            out+="8"
            input.text = out
            input.alpha = 1F
        }
        val nine = findViewById<Button>(R.id.nine).setOnClickListener{
            out+="9"
            input.text = out
            input.alpha = 1F
        }
        val zero = findViewById<Button>(R.id.zero).setOnClickListener{
            out+="0"
            input.text = out
            input.alpha = 1F
        }
        val C = findViewById<Button>(R.id.C).setOnClickListener{
            out=""
            temp = ""
            input.text = out
            cache.text = temp
        }
        // Signs
        val plus = findViewById<Button>(R.id.plus).setOnClickListener{
            temp = out
            cache.text = temp.toString()
            out = ""
            sign = 1
        }
        val minus = findViewById<Button>(R.id.minus).setOnClickListener{
            temp = out
            cache.text = temp.toString()
            out = ""
            sign = 2
        }
        val multiply = findViewById<Button>(R.id.multiply).setOnClickListener{
            temp = out
            cache.text = temp.toString()
            out = ""
            sign = 3
        }
        val divide = findViewById<Button>(R.id.divide).setOnClickListener{
            temp = out
            cache.text = temp.toString()
            out = ""
            sign = 4
        }
        val equals = findViewById<Button>(R.id.equals).setOnClickListener{
            try {
                when (sign) {
                    1 -> input.text = (temp.toLong() + out.toLong()).toString()
                    2 -> input.text = (temp.toLong() - out.toLong()).toString()
                    3 -> input.text = (temp.toLong() * out.toLong()).toString()
                    4 -> input.text = (temp.toLong() / out.toLong()).toString()
                    0 -> input.text = "INVALID SIGN"
                }
            }
            catch (Exception: ArithmeticException) {
                input.text = "ERROR"
            }
        }

        Thread{
            while (true){
                if (temp == "" || temp == "|") {
                    runOnUiThread { cache.alpha = 0.1F }
                }
                if (out == "" || temp == "|") {
                    runOnUiThread { input.alpha = 0.1F }
                }
            Thread.sleep(1000)
            runOnUiThread { cache.alpha = 1F }
            runOnUiThread { input.alpha = 1F }
            Thread.sleep(1000)
            }
        }.start()

    }
}
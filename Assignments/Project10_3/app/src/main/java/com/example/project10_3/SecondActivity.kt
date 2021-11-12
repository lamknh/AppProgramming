package com.example.project10_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second)
        title = "Second 액티비티"

        var inIntent = intent

        var num1 = inIntent.getIntExtra("Num1", 0)
        var num2 = inIntent.getIntExtra("Num2", 0)
        var operator = inIntent.getStringExtra("Operator")

        var result = 0 //결과값
        when(operator)
        {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> result = num1 / num2
        }



        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", result)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}
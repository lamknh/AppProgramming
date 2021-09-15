package com.example.fourbutton

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"))
            startActivity(mIntent)
        }

        button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel://911"))
            startActivity(mIntent)
        }

        button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"))
            startActivity(mIntent)
        }

        button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            finish()
        }

    }
}
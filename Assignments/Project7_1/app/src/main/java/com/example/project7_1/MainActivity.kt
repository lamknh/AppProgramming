package com.example.project7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import java.lang.Float.parseFloat

class MainActivity : AppCompatActivity() {
    lateinit var baseLayout : RelativeLayout
    lateinit var picture : ImageView
    lateinit var degree : EditText
    lateinit var num : String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseLayout = findViewById(R.id.baseLayout)
        picture = findViewById(R.id.picture)
        degree = findViewById(R.id.enterDegree)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //메뉴 클릭시 동작
        when (item.itemId){
            R.id.rotate -> {
                num = degree.text.toString()
                picture.rotation = parseFloat(num)
                return true
            }
            R.id.item1 -> {
                picture.setBackgroundResource(R.drawable.jeju1)
                return true
            }
            R.id.item2 -> {
                picture.setBackgroundResource(R.drawable.jeju2)
                return true
            }
            R.id.item3 -> {
                picture.setBackgroundResource(R.drawable.jeju3)
                return true
            }
        }
        return false
    }
}
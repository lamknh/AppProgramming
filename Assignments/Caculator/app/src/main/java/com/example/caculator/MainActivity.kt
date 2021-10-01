package com.example.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Double.parseDouble

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var btnRem : Button;
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String
    var result : Double? = null
    var result2 : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)
        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        btnRem = findViewById(R.id.BtnRem)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnClickListener { motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            if(num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                result = parseDouble(num1) + parseDouble(num2)
                textResult.text = "계산 결과 : " + result.toString()
            }

            false
        }

        btnSub.setOnClickListener{ motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                result = parseDouble(num1) - parseDouble(num2)
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnMul.setOnClickListener { motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                result = parseDouble(num1) * parseDouble(num2)
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnDiv.setOnClickListener { motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (num2 == "0" ){
                Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show()
            } else {
                result = parseDouble(num1) / parseDouble(num2)
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnRem.setOnClickListener { motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.length == 0 || num2.length == 0){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                result2 = Integer.parseInt(num1) % Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result2.toString()
            }
            false
        }
    }
}
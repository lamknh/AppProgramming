package com.example.project7_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var tvName : EditText
    lateinit var tvEmail : EditText
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText: TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        button1 = findViewById(R.id.button1)

        button1.setOnClickListener{
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlgEdtName = dialogView.findViewById(R.id.dlgEdt1)
            dlgEdtEmail = dialogView.findViewById(R.id.dlgEdt2)

            dlgEdtName.text = tvName.text
            dlgEdtEmail.text = tvEmail.text
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
            dlg.setView(dialogView)
            dlg.setPositiveButton("확인"){ dialog, which ->
                tvName.text = dlgEdtName.text
                tvEmail.text = dlgEdtEmail.text
            }
            dlg.setNegativeButton("취소"){ dialog, which ->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1, null)
                toastText = toastView.findViewById(R.id.toastText1)
                toastText.text = "취소했습니다"
                toast.view = toastView
                var display = (getSystemService(Context.WINDOW_SERVICE) as
                        WindowManager).defaultDisplay
                var xOffset = (Math.random() * display.width).toInt()
                var yOffset = (Math.random() * display.height).toInt()

                toast.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)
                toast.show()
            }
            dlg.show()
        }
    }
}
package org.techtown.sopt_week_1

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 101
    private var checking : Boolean = false // 회원가입 절차 완료했는지 확인

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUp_tv.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        signUp_tv.setOnClickListener {
            var intent = Intent(this,SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        button.setOnClickListener {
            if (checking == false){
                Toast.makeText(this, "회원가입을 해주세요",Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this,"로그인 완료 히히",Toast.LENGTH_LONG).show()
                intent = Intent(this,ImageAcitivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var email = data?.getStringExtra("email")
            var password = data?.getStringExtra("password")
            checking = true

            email_tv.setText(email)
            password_tv.setText(password)

        }
    }
}

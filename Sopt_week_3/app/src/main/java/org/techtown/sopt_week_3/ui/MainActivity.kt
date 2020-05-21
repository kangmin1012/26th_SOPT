package org.techtown.sopt_week_3.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.sopt_week_3.R
import org.techtown.sopt_week_3.api.SignServiceImpl
import org.techtown.sopt_week_3.data.RequestSignIn
import org.techtown.sopt_week_3.util.customEnqueue
import org.techtown.sopt_week_3.util.showToast
import org.techtown.sopt_week_3.util.textListener

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 101
    private val mRequest : SignServiceImpl = SignServiceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUp_tv.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        signUp_tv.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        button.setOnClickListener {
            mRequest.service.postSignIn(
                RequestSignIn(
                    id = email_tv.text.toString(),
                    password = password_tv.text.toString()
                )
            ).customEnqueue(
                onError = {showToast("요청 오류")},
                onSuccess = {
                    showToast(it.message)
                    if (it.success == true){
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }

                }
            )

        }

        email_tv.textListener {
            if(it.isNullOrBlank()) {
                showToast("빈칸입니다.")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var id = data?.getStringExtra("id")
            var password = data?.getStringExtra("password")

            email_tv.setText(id)
            password_tv.setText(password)

        }
    }
}

package org.techtown.sopt_week_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var email : String
    private lateinit var password : String
    private lateinit var gitHub : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_btn.setOnClickListener {
            email = sign_up_email_tv.text.toString()
            password = sign_up_password_tv.text.toString()
            gitHub = sign_up_github_tv.text.toString()

            if (email == null || password == null) {
                Toast.makeText(this,"이메일과 비밀번호를 입력해 주세요."
                    ,Toast.LENGTH_LONG).show()
            }

            else if (password != sign_up_password_check_tv.text.toString()){
                Toast.makeText(this,"비밀번호 확인이 일치하지 않습니다."
                    ,Toast.LENGTH_LONG).show()
            }

            else {
                Toast.makeText(this,"회원가입이 완료되었습니다."
                    ,Toast.LENGTH_LONG).show()

                val intent = Intent()
                intent.putExtra("email",email)
                intent.putExtra("password",password)

                setResult(Activity.RESULT_OK,intent)
                finish()
            }

        }

    }
}

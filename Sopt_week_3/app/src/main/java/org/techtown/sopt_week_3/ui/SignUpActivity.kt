package org.techtown.sopt_week_3.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.techtown.sopt_week_3.R
import org.techtown.sopt_week_3.api.SignServiceImpl
import org.techtown.sopt_week_3.util.customEnqueue
import org.techtown.sopt_week_3.data.RequestSignUp
import org.techtown.sopt_week_3.util.showToast

class SignUpActivity : AppCompatActivity() {

    private lateinit var email : String
    private lateinit var password : String
    private lateinit var id : String

    private val mRequest : SignServiceImpl = SignServiceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_btn.setOnClickListener {
            email = sign_up_email_tv.text.toString()
            password = sign_up_password_tv.text.toString()
            id = sign_up_id_tv.text.toString()

            if (email.equals("") || password.equals("")) {
                Toast.makeText(this,"이메일과 비밀번호를 입력해 주세요."
                    ,Toast.LENGTH_LONG).show()
            }

            else if (password != sign_up_password_check_tv.text.toString()){
                Toast.makeText(this,"비밀번호 확인이 일치하지 않습니다."
                    ,Toast.LENGTH_LONG).show()
            }
            else {
                mRequest.service.postSignUp(
                    RequestSignUp(
                        id = sign_up_id_tv.text.toString(),
                        password = sign_up_password_tv.text.toString(),
                        name = "밍맹",
                        email = sign_up_email_tv.text.toString(),
                        phone = "000-0000-0000"
                    )
                ).customEnqueue(
                    onError = {showToast("요청 오류") },
                    onSuccess = {
                        showToast("${it.message}")

                        if(it.success){
                            val intent = Intent()
                            intent.putExtra("id",id)
                            intent.putExtra("password",password)

                            setResult(Activity.RESULT_OK,intent)
                            finish()
                        }

                    }
                )
            }

        }

    }
}

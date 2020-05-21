package org.techtown.sopt_week_3.api

import org.techtown.sopt_week_3.data.RequestSignIn
import org.techtown.sopt_week_3.data.RequestSignUp
import org.techtown.sopt_week_3.data.ResponseSignIn
import org.techtown.sopt_week_3.data.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignService {
    @POST("/user/signin")
    fun postSignIn(
        @Body body : RequestSignIn
    ) : Call<ResponseSignIn>

    @POST("/user/signup")
    fun postSignUp(
        @Body body : RequestSignUp

    ) :Call<ResponseSignUp>
}
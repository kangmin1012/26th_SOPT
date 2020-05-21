package org.techtown.sopt_week_3.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun Context.showToast(msg : String){
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun EditText.textListener(textChanged : (CharSequence?) -> Unit){
    this.addTextChangedListener( object : TextWatcher{
        override fun afterTextChanged(s: Editable?) = Unit

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textChanged(s)
        }
    })

}

fun<ResponseType> Call<ResponseType>.customEnqueue(
    onFail : () -> Unit = { Log.d("network","통신 실패")},
    onSuccess : (ResponseType) -> Unit,
    onError : () -> Unit
){
    this.enqueue(object : Callback<ResponseType>{
        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            onFail()
        }

        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            response.takeIf { it.isSuccessful }
                ?.body()
                ?.let {
                //body Null -> statusCode 200 or 300
                onSuccess(it)
            } ?: onError()
        }
    })
}
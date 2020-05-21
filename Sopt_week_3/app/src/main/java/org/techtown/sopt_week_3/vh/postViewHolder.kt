package org.techtown.sopt_week_3.vh

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.techtown.sopt_week_3.R
import org.techtown.sopt_week_3.data.postData

class postViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
    var profile = itemview.findViewById<ImageView>(R.id.user_profile_img)
    var user = itemview.findViewById<TextView>(R.id.user_tv)
    var post = itemview.findViewById<ImageView>(R.id.post_img)

    private val glideManager : RequestManager = Glide.with(itemView)

    fun onBind(data : postData){

        // 유저 닉네임
        user.text = data.user

        loading(data.profile, profile)
        loading(data.post, post)
    }

    private fun loading(url : String, view : ImageView){

        view.post {
            glideManager.load(url)
                .error(R.drawable.handwash)
                .into(view)
        }
    }


}
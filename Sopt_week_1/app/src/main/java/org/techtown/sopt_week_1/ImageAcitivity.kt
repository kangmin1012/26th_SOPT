package org.techtown.sopt_week_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image_acitivity.*

class ImageAcitivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_acitivity)

        Glide.with(this)
            .load(R.drawable.patrick)
            .error(R.drawable.sopt_logo)
            .into(center_img)
    }
}

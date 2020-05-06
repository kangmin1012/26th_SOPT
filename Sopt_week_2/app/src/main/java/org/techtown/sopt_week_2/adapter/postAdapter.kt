package org.techtown.sopt_week_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.sopt_week_2.R
import org.techtown.sopt_week_2.VH.postViewHolder
import org.techtown.sopt_week_2.data.postData

class postAdapter(private val context : Context) : RecyclerView.Adapter<postViewHolder>(){

    var data = arrayListOf<postData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rcv_item,parent,false)
        return postViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        holder.onBind(data[position])
    }


}
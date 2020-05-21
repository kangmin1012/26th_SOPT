package org.techtown.sopt_week_3.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment2.*
import kotlinx.android.synthetic.main.fragment_fragment2.view.*
import org.techtown.sopt_week_2.adapter.postAdapter
import org.techtown.sopt_week_3.R
import org.techtown.sopt_week_3.data.postData
import org.techtown.sopt_week_3.util.ItemDeco

class Fragment2 : Fragment() {

    private lateinit var gridadapter : postAdapter
    private val IMG_URL = "https://cdn.pixabay.com/photo/2020/05/01/11/26/poppy-5116562__340.jpg"
    private val PROFILE_URL ="https://cdn.pixabay.com/photo/2020/05/03/18/57/stand-5126363__340.jpg"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_fragment2, container, false)
        initGrid(v)
        return v
    }

    private fun initGrid(v : View){

        gridadapter = postAdapter(v.context)
        v.grid_rcv.adapter = gridadapter
        v.grid_rcv.apply{
            layoutManager = GridLayoutManager(v.context,2,GridLayoutManager.VERTICAL,false)
            addItemDecoration(ItemDeco(v.context,true))
        }

        gridadapter.data = arrayListOf(
            postData(
                PROFILE_URL
                ,"밍구"
                ,IMG_URL
            )
            ,
            postData(
                PROFILE_URL,
                "안드사랑 나라사랑"
                ,IMG_URL
            ),

            postData(
                PROFILE_URL,
                "꽃길만 걷자"
                ,IMG_URL
            ),

            postData(
                PROFILE_URL,
                "ㄴㅁㅇㄹㄴ"
                ,IMG_URL
            ),

            postData(
                PROFILE_URL,
                "1"
                ,IMG_URL
            ),
            postData(
                PROFILE_URL,
                "2"
                ,IMG_URL
            ),
            postData(
                PROFILE_URL,
                "3"
                ,IMG_URL
            ),
            postData(
                PROFILE_URL,
                "4"
                ,IMG_URL
            ),
            postData(
                PROFILE_URL,
                "5"
                ,IMG_URL
            )
        )

        gridadapter.notifyDataSetChanged()

    }



}

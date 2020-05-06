package org.techtown.sopt_week_2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment1.*
import kotlinx.android.synthetic.main.fragment_fragment1.view.*
import org.techtown.sopt_week_2.Utill.ItemDeco
import org.techtown.sopt_week_2.adapter.postAdapter
import org.techtown.sopt_week_2.data.postData

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    private lateinit var adapter : postAdapter
    private val IMG_URL = "https://cdn.pixabay.com/photo/2020/05/01/11/26/poppy-5116562__340.jpg"
    private val PROFILE_URL ="https://cdn.pixabay.com/photo/2020/05/03/18/57/stand-5126363__340.jpg"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_fragment1, container, false)

        initRcv(v)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRcv(v : View) {
        adapter = postAdapter(v.context)
        v.frag1_rcv.adapter = adapter
        v.frag1_rcv.apply{
            layoutManager = LinearLayoutManager(v.context)
            addItemDecoration(ItemDeco(v.context))
        }

            adapter.data = arrayListOf(
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
                    "마지막쓰"
                    ,IMG_URL
                )
            )

            adapter.notifyDataSetChanged()
        }
    }


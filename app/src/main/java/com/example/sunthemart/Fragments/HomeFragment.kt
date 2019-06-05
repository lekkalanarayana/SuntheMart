package com.example.sunthemart.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunthemart.Adapter.HomeAdapter
import com.example.sunthemart.Model.HomeData

import com.example.sunthemart.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    var mRootView:View?=null
    var xRecyclerView:RecyclerView?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        mRootView=inflater.inflate(R.layout.fragment_home, container, false)
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mInitWedgets()
        mInitObjects()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun mInitObjects() {



    }

    private fun mInitWedgets() {
        xRecyclerView= mRootView?.findViewById(R.id.xRecyclerview)
        xRecyclerView?.layoutManager=LinearLayoutManager(activity)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<HomeData>()

        //adding some dummy data to the list
        users.add(HomeData(R.drawable.bana_icon))
        users.add(HomeData(R.drawable.apple_icon))
        users.add(HomeData(R.drawable.bri_icon))
        users.add(HomeData(R.drawable.carrot_icon))
        users.add(HomeData(R.drawable.brin_icon))
        users.add(HomeData(R.drawable.sug1_icon))
        users.add(HomeData(R.drawable.sug2_icon))
        users.add(HomeData(R.drawable.sug3_icon))
        users.add(HomeData(R.drawable.sug4_icon))

        val adapter = activity?.let { HomeAdapter(it,users) }
        xRecyclerView?.adapter = adapter




    }


}






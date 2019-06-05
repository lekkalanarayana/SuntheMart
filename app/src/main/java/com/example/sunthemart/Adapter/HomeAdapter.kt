package com.example.sunthemart.Adapter

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.sunthemart.Model.HomeData
import com.example.sunthemart.R
import kotlinx.android.synthetic.main.home_custom_dialog.view.*

class HomeAdapter(val context : Context,val list:ArrayList<HomeData>) : RecyclerView.Adapter<HomeadapterItems>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeadapterItems {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.home_adapter_items, p0, false)
        return HomeadapterItems(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: HomeadapterItems, p1: Int) {
      p0.bindItems(context,list[p1])




    }


}
class HomeadapterItems(itemview:View) :RecyclerView.ViewHolder(itemview){
    fun bindItems( mContaxt:Context,homedata: HomeData) {
        val image  = itemView.findViewById<ImageView>(R.id.x_Iv_home_veg)
        val m_Iv_Add=itemView.findViewById<ImageView>(R.id.x_Iv_Add)
        m_Iv_Add.setOnClickListener {
            val mDialogView = LayoutInflater.from(mContaxt).inflate(R.layout.home_custom_dialog, null)
            val mBuilder = AlertDialog.Builder(mContaxt)
                .setView(mDialogView)
            val  mAlertDialog = mBuilder.show()
            mDialogView.x_Dialog_Dismis.setOnClickListener{
                mAlertDialog.dismiss()
            }

        }


        image.setImageResource(homedata.image)
    }
}
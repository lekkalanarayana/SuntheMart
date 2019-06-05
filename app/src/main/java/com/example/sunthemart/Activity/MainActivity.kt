package com.example.sunthemart.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import com.example.sunthemart.R
import android.app.FragmentManager
import android.app.PendingIntent.getActivity
import android.widget.FrameLayout
import com.example.sunthemart.Fragments.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    lateinit var xDrawerLayout:DrawerLayout

    lateinit var mMain_FrameLayout:FrameLayout
    lateinit var navigationView:NavigationView
    lateinit var mIv_Menu:RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mInitWedgets()
        mInitObjects()
    }

    private fun mInitObjects() {
        val fm = this.getSupportFragmentManager()
        fm.beginTransaction()
            .replace(R.id.xMain_FrameLayout, HomeFragment())
            .addToBackStack(null)
            .commit()

    }

    private fun mInitWedgets() {
        navigationView=findViewById(R.id.nav_view);
        xDrawerLayout=findViewById(R.id.xDrawerLayout);
        mMain_FrameLayout=findViewById(R.id.xMain_FrameLayout);

        navigationView.setNavigationItemSelectedListener(this)
        mIv_Menu=findViewById(R.id.xIv_Menu)
        mIv_Menu.setOnClickListener(this)
    }
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var fragment:Fragment?=null

        when(p0.itemId){
            R.id.xIt_Home->{
                fragment = HomeFragment()



            }
            R.id.xIt_yourorder->{
                fragment = YourOrdersFragment()


            }
            R.id.xIt_History->{
                fragment = HistoryFragment()


            }
            R.id.xIt_Notifications->{
                fragment = NotificationFragment()


            }
            R.id.xIt_ContactUs->{
                fragment = ContactFragment()


            }
            R.id.xIt_Logout->{
                fragment = LogoutFragment()

            }

        }
        if(fragment !=null){
            val fm = this.getSupportFragmentManager()
            fm.beginTransaction()
                .replace(R.id.xMain_FrameLayout, fragment)
                .addToBackStack(null)
                .commit()

        }
        xDrawerLayout.closeDrawer(GravityCompat.START)
         return true
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.xIv_Menu->{
                xDrawerLayout.openDrawer(GravityCompat.START)

            }

        }



    }
    override fun onBackPressed() {
        if (xDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            xDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

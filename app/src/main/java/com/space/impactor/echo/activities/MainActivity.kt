package com.space.impactor.echo.activities

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.space.impactor.echo.R
import com.space.impactor.echo.adapters.NavigationDrawerAdapter
import com.space.impactor.echo.fragments.MainScreenFragment

class MainActivity : AppCompatActivity() {

    var navigationDrawerIconsList: ArrayList<String> = arrayListOf()

    var images_for_navdrawer = intArrayOf(R.drawable.navigation_allsongs,R.drawable.navigation_favorites,
            R.drawable.navigation_settings,R.drawable.navigation_aboutus)

object Statified{
    var drawerLayout : DrawerLayout?=null
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar =findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        MainActivity.Statified.drawerLayout = findViewById(R.id.drawer_layout)


        navigationDrawerIconsList.add("All Songs")
        navigationDrawerIconsList.add("Favorites")
        navigationDrawerIconsList.add("Settings")
        navigationDrawerIconsList.add("About Us")



        val toggle =ActionBarDrawerToggle(this@MainActivity,MainActivity.Statified.drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        MainActivity.Statified.drawerLayout?.setDrawerListener(toggle)
        toggle.syncState()

        val mainScreenFragment = MainScreenFragment()
        this.supportFragmentManager
                .beginTransaction()
                .add(R.id.details_fragment,mainScreenFragment,"MainScreenFragment")
                .commit()

        var _navigaionAdapter = NavigationDrawerAdapter(navigationDrawerIconsList,images_for_navdrawer,this)
        _navigaionAdapter.notifyDataSetChanged()

        var navigation_recycler_view =findViewById<RecyclerView>(R.id.navigation_recycler_view)
        navigation_recycler_view.layoutManager = LinearLayoutManager(this)
        navigation_recycler_view.itemAnimator = DefaultItemAnimator()
        navigation_recycler_view.adapter = _navigaionAdapter
        navigation_recycler_view.setHasFixedSize(true)

    }

    override fun onStart() {
        super.onStart()
    }
}

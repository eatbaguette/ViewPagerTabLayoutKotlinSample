package com.wacode.yuki.modernapp

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private fun setViews() {
        toolbar = findViewById(R.id.main_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val manager = supportFragmentManager
        val viewPager = findViewById(R.id.main_viewpager) as ViewPager
        val adapter = ExampleFragmentPagerAdapter(manager)
        viewPager.adapter = adapter
        setDrawer()
        val tabLayout = findViewById(R.id.main_tab) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setDrawer() {
        drawerLayout = findViewById(R.id.main_drawer) as DrawerLayout
        val navigationView = findViewById(R.id.main_drawer_navigation) as NavigationView

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        drawerLayout
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(select)
    }

    private val select = NavigationView.OnNavigationItemSelectedListener {
        //本来ならここで分岐の処理を
        drawerLayout!!.closeDrawers()
        true
    }
}

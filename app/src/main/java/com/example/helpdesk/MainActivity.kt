package com.example.helpdesk

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tabBar)
        val viewPager: ViewPager = findViewById(R.id.viewPager)




 setUpTabs()

        val fab: View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            val intent = Intent(this, ShowTask::class.java)
            startActivity(intent)
        }



    }
    private fun setUpTabs(){
        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(TabFragment(),"first")
        adapter.addFragment(TabFragment(),"sec")
        adapter.addFragment(TabFragment(),"thr")
        viewPager.adapter = adapter
        tabBar.setupWithViewPager(viewPager)


    }
}
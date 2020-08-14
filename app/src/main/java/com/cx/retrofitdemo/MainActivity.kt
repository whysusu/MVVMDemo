package com.cx.retrofitdemo


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cx.retrofitdemo.base.BaseActivity
import com.cx.retrofitdemo.base.DataGenerator
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_layout.*


class MainActivity : BaseActivity() {

    private lateinit var fragments: MutableList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragments = DataGenerator.getFragment()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                onTabSelected(p0?.position)
                var tabCount = tabLayout.tabCount
                for (i in 0 until tabCount) {
                    var tabView = tabLayout.getTabAt(i)?.customView
                    var tabIcon = tabView?.findViewById<ImageView>(R.id.tabIcon)
                    var tabText = tabView?.findViewById<TextView>(R.id.tabText)
                    if (i == p0?.position) {
                        tabIcon?.setImageResource(DataGenerator.tabsSelect[i])
                        tabText?.setTextColor(resources.getColor(R.color.color1296db))
                    } else {
                        tabIcon?.setImageResource(DataGenerator.tabsDefault[i])
                        tabText?.setTextColor(resources.getColor(R.color.color515151))
                    }
                }
            }

        })
        var size = fragments.size
        for (i in 0 until size) {
            tabLayout.addTab(tabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)))
        }

    }

    fun onTabSelected(pos: Int?) {
        if (::fragments.isInitialized) {
            var transaction = supportFragmentManager.beginTransaction()
            for (i in 0 until fragments.size) {
                if(!fragments[i].isAdded){
                    transaction.add(R.id.framLyout,fragments[i])
                }
                if (i == pos) {
                    transaction.show(fragments[i])
                } else {
                    transaction.hide(fragments[i])
                }
            }
            transaction.commit()
        }

    }

}


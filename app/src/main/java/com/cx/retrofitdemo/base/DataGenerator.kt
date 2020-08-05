package com.cx.retrofitdemo.base

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.cx.retrofitdemo.*
import kotlinx.android.synthetic.main.tab_layout.view.*

/**
 * @ClassName: DataGenerator
 * @Author: CX
 * @Date: 2020/7/30 13:14
 */
class DataGenerator {

    companion object {
        var tabsSelect = mutableListOf<Int>(
            R.mipmap.hj_on,
            R.mipmap.galaxy_on,
            R.mipmap.moon_on,
            R.mipmap.star_on,
            R.mipmap.person_on
        )
        var tabsDefault = mutableListOf<Int>(
            R.mipmap.hj_off,
            R.mipmap.galaxy_off,
            R.mipmap.moon_off,
            R.mipmap.star_off,
            R.mipmap.person_off
        )
        var tabTitle = mutableListOf<String>("首页", "发现", "消息", "朋友", "我的")
        fun getFragment(): MutableList<Fragment> {
            var fragments = mutableListOf<Fragment>()
            fragments.add(FirstFragment.instance)
            fragments.add(SecondFragment.instance)
            fragments.add(ThirdFragment.instance)
            fragments.add(FourthFragment.instance)
            fragments.add(FifthFragment.instance)
            return fragments
        }

        fun getTabView(context: Context, pos: Int): View {
            var view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null)
            view.tabIcon.setImageResource(tabsSelect[pos])
            view.tabText.text = tabTitle[pos]
            return view
        }
    }
}
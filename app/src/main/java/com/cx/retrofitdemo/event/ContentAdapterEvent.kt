package com.cx.retrofitdemo.event

import android.content.Intent
import android.view.View
import com.blankj.utilcode.util.ActivityUtils.startActivity
import com.blankj.utilcode.util.ToastUtils
import com.cx.retrofitdemo.DetailActivity
import com.cx.retrofitdemo.R
import com.cx.retrofitdemo.bean.IndexPreferredDataBean

/**
 * @ClassName: ContentAdapterEvent
 * @Author: CX
 * @Date: 2020/8/5 16:29
 */
class ContentAdapterEvent {
    fun itemClick(view: View, bean: IndexPreferredDataBean) {
        ToastUtils.showShort(bean.title)
        var intent = Intent(view.context, DetailActivity::class.java)
        startActivity(intent)
    }

    fun itemChildClick(view: View, bean: IndexPreferredDataBean) {
        when (view.id) {
            R.id.tv_housing_name_list -> {
                ToastUtils.showShort("标题:" + bean.buildingName)
            }
            R.id.tv_total_price -> {
                ToastUtils.showShort("价格:" + bean.price)
            }
            else -> {
                return
            }
        }

    }
}
package com.cx.retrofitdemo

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cx.retrofitdemo.base.BaseActivity
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.databinding.ActivityDetailLayoutBinding
import com.cx.retrofitdemo.viewmodel.DetailViewModel
import com.cx.retrofitdemo.viewmodel.DetailViewModelManagerFactory
import kotlinx.android.synthetic.main.activity_detail_layout.*
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

/**
 * @ClassName: DetailActivity
 * @Author: CX
 * @Date: 2020/8/14 10:28
 */
class DetailActivity : BaseActivity(), KodeinAware {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_layout)
        var dataBinding = DataBindingUtil.setContentView<ActivityDetailLayoutBinding>(
            this,
            R.layout.activity_detail_layout
        )
        val retrofitAPI by instance<RetrofitAPI>()
        var detailViewModel = ViewModelProvider(
            this,
            DetailViewModelManagerFactory(retrofitAPI)
        ).get(DetailViewModel::class.java)
        detailViewModel.getNHDetails()
        detailViewModel.detailsLiveData.observe(this, Observer {
            when (it.resultState) {
                ResultState.LOADING -> {
                    contentTV.text = "正在加载数据"
                }
                ResultState.ERROR -> {
                    contentTV.text = "数据加载错误"
                }
                ResultState.SUCCESS -> {
//                    contentView.contentDetail.text = "返回$it"
//                    contentView.contentDetail.text = it.data.goodBuildings[0].name
                    dataBinding.dataBean = it.data
                }
            }
        })

    }

}
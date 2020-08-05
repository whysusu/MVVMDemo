package com.cx.retrofitdemo


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.ToastUtils
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.viewmodel.MainViewModel
import com.cx.retrofitdemo.viewmodel.MainViewModelManagerFactory
import kotlinx.android.synthetic.main.frag_first_layout.view.*
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


/**
 * @ClassName: FirstFragment
 * @Author: CX
 * @Date: 2020/7/9 14:42
 */
class FirstFragment : Fragment(), KodeinAware {
    /**
     * 单例
     * **/
    companion object {
        val instance: FirstFragment by lazy {
            FirstFragment()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var contentView = inflater.inflate(R.layout.frag_first_layout, null)
        val retrofitAPI: RetrofitAPI by instance<RetrofitAPI>()
        val nhViewModel: MainViewModel = ViewModelProvider(
            activity as MainActivity,
            MainViewModelManagerFactory(retrofitAPI)
        ).get(MainViewModel::class.java)
        nhViewModel.nhLiveData.observe(activity as MainActivity, Observer {

            var bean = it.data
            Log.i("cx---", bean.toString())
//            Log.i("cx---bean", bean?.get(0)?.name)
            if (it.resultState == ResultState.LOADING) {
                contentView.content.text = "正在加载数据"
            } else if (it.resultState == ResultState.ERROR) {
                contentView.content.text = "数据加载错误"
            } else if (it.resultState == ResultState.SUCCESS) {
//                contentView.content.text = "返回:$it"
                contentView.content.text = bean?.get(0)?.name
            }
        })

        contentView.jumpBtn.setOnClickListener {
            var bean = nhViewModel.nhLiveData.value
            if (bean?.data != null && bean.data.size > 0) {
                contentView.secondTV.text = "这里是取到的值：" + bean.data[0].areaName
            } else {
                ToastUtils.showShort("data是空的")
            }

        }

        nhViewModel.nhDetailsLiveData.observe(activity as MainActivity, Observer {
            when (it.resultState) {
//                ResultState.LOADING -> {
//                    contentView.contentDetail.text = "正在加载数据"
//                }
//                ResultState.ERROR -> {
//                    contentView.contentDetail.text = "数据加载错误"
//                }
//                ResultState.SUCCESS -> {
////                    contentView.contentDetail.text = "返回$it"
//                    contentView.contentDetail.text = it.data.goodBuildings[0].name
//                }
            }

        })
        return contentView
    }

    val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy { extend(parentKodein, copy = Copy.All) }


}
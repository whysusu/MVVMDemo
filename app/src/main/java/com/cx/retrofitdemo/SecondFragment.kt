package com.cx.retrofitdemo

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.viewmodel.MainViewModel
import com.cx.retrofitdemo.viewmodel.MainViewModelManagerFactory
import kotlinx.android.synthetic.main.frag_sec_layout.view.*
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

/**
 * @ClassName: SecondFragment
 * @Author: CX
 * @Date: 2020/7/9 14:46
 */
class SecondFragment : Fragment(), KodeinAware {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var contentView = inflater.inflate(R.layout.frag_sec_layout, null)
        //从kodein中拿到RetrofitNHManager的对象
        val retrofitAPI: RetrofitAPI by instance<RetrofitAPI>()

        //注意，这里初始化MainViewModel和底下监听nhLiveData时使用的ViewModelStoreOwner都必须是外层activity父类能实现数据共享，如果使用this，则表示在当前fragment更新数据
        val nhViewModel: MainViewModel = ViewModelProvider(
            activity as MainActivity,
            MainViewModelManagerFactory(retrofitAPI)
        ).get(MainViewModel::class.java)

        nhViewModel.nhLiveData.observe(activity as MainActivity, Observer {
            if (it.resultState == ResultState.LOADING) {
                contentView.content.text = "正在加载数据"
            } else if (it.resultState == ResultState.ERROR) {
                contentView.content.text = "数据加载错误"
            } else if (it.resultState == ResultState.SUCCESS) {
                contentView.content.text = "返回$it"
            }
        })

        contentView.frag_button.setOnClickListener {
            nhViewModel.getNHData()
        }
        return contentView
    }

    val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy { extend(parentKodein, copy = Copy.All) }
}
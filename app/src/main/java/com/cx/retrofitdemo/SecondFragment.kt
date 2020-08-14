package com.cx.retrofitdemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cx.retrofitdemo.adapter.ContentAdapter
import com.cx.retrofitdemo.adapter.TitleAdatper
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.databinding.FragSecLayoutBinding
import com.cx.retrofitdemo.viewmodel.MainViewModel
import com.cx.retrofitdemo.viewmodel.MainViewModelManagerFactory
import kotlinx.android.synthetic.main.frag_sec_layout.view.*
import kotlinx.android.synthetic.main.test_head_view.view.*
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
    companion object {
        val instance: SecondFragment by lazy { SecondFragment() }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        var contentView = inflater.inflate(R.layout.frag_sec_layout, null)

        //从kodein中拿到RetrofitNHManager的对象
        val retrofitAPI: RetrofitAPI by instance<RetrofitAPI>()

        //注意，这里初始化MainViewModel和底下监听nhLiveData时使用的ViewModelStoreOwner都必须是外层activity父类能实现数据共享，如果使用this，则表示在当前fragment更新数据
        val nhViewModel: MainViewModel = ViewModelProvider(
            activity as MainActivity,
            MainViewModelManagerFactory(retrofitAPI)
        ).get(MainViewModel::class.java)



        var binding = DataBindingUtil.inflate<FragSecLayoutBinding>(
            inflater,
            R.layout.frag_sec_layout,
            null,
            false
        )
        binding.viewModle = nhViewModel
        var contentView = binding.root

        contentView.contentRV.layoutManager = LinearLayoutManager(context)
        var contentAdapter = ContentAdapter()
        contentView.contentRV.adapter = contentAdapter


        nhViewModel.nhLiveData.observe(activity as MainActivity, Observer { it ->
            when (it.resultState) {

                ResultState.LOADING -> {
                    Log.i("cx---", "正在加载数据")
//                    contentView.content.text = "正在加载数据"
                }
                ResultState.ERROR -> {
                    Log.i("cx---", "数据加载错误")
//                    contentView.content.text = "数据加载错误"
                }
                ResultState.SUCCESS -> {
//                    Log.i("cx---", "返回$it")
//                    contentView.content.text = "返回$it"
                }
            }

        })


        nhViewModel.esLiveData.observe(activity as MainActivity, Observer {
            when (it.resultState) {

                ResultState.LOADING -> {
                    Log.i("cx---", "正在加载数据")
//                    contentView.content.text = "正在加载数据"
                }
                ResultState.ERROR -> {
                    Log.i("cx---", "数据加载错误")
//                    contentView.content.text = "数据加载错误"
                }
                ResultState.SUCCESS -> {
                    Log.i("cx---", "返回二手房${it.data[0].houseType}")
//                    contentView.content.text = "返回$it"
                    contentAdapter.setList(it.data)
                }
            }
        })


        nhViewModel.czLiveData.observe(activity as MainActivity, Observer {
            when (it.resultState) {

                ResultState.LOADING -> {
                    Log.i("cx---", "正在加载数据")
//                    contentView.content.text = "正在加载数据"
                }
                ResultState.ERROR -> {
                    Log.i("cx---", "数据加载错误")
//                    contentView.content.text = "数据加载错误"
                }
                ResultState.SUCCESS -> {
                    Log.i("cx---", "返回出租房${it.data[0].houseType}")
//                    contentView.content.text = "返回$it"
                }
            }
        })

        contentView.titleRV.layoutManager = LinearLayoutManager(context)
        contentView.titleRV.isNestedScrollingEnabled = false
        titleAdatper = TitleAdatper()
        contentView.titleRV.adapter = titleAdatper
        var view = LayoutInflater.from(context).inflate(R.layout.test_head_view, null)
        view.headViewRv.layoutManager = LinearLayoutManager(context)


        //头部
        headViewAdapter = TitleAdatper()
        view.headViewRv.adapter = headViewAdapter
        titleAdatper.addHeaderView(view)
        var headList = mutableListOf<String>("2小时", "电影", "星际穿越", "什么的")
        headViewAdapter.setList(headList)


        //标题相关
        nhViewModel.titleLiveData.observe(activity as MainActivity, Observer {
            titleAdatper.setList(it)
        })

        return contentView
    }

    private lateinit var headViewAdapter: TitleAdatper
    private lateinit var titleAdatper: TitleAdatper
    val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy { extend(parentKodein, copy = Copy.All) }
}
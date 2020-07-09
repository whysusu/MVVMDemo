package com.cx.retrofitdemo


import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cx.retrofitdemo.base.BaseActivity
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.viewmodel.MainViewModelManager


import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //从kodein中拿到RetrofitNHManager的对象
        val retrofitAPI:RetrofitAPI by instance<RetrofitAPI>()
        var mainViewModelManager = MainViewModelManager(this,retrofitAPI)

        mainViewModelManager.nhLiveData.observe(this, Observer {
            if (it.resultState == ResultState.LOADING) {
                testTV.text = "正在加载数据"
            } else if (it.resultState == ResultState.ERROR) {
                testTV.text = "数据加载错误"
            } else if (it.resultState == ResultState.SUCCESS) {
                testTV.text = "返回" + it.data.size + "条数据"
            }
        })
//
//        val nhViewModel: NHViewModel =
//            ViewModelProvider(this, NHVIewModelFactroy(apiManager)).get(
//                NHViewModel::class.java
//            )


//        nhViewModel.nhListLiveData.observe(this, Observer {
//
//            if (it.resultState == ResultState.LOADING) {
//                testTV.text = "正在加载数据"
//            } else if (it.resultState == ResultState.ERROR) {
//                testTV.text = "数据加载错误"
//            } else if (it.resultState == ResultState.SUCCESS) {
//                testTV.text = "返回" + it.data.size + "条数据"
//            }
//
//        })


        Button.setOnClickListener {
            //这里是使用LiveData和ViewModel的模式来请求数据，简单测试了下横竖屏切换后的数据变化，横竖屏切换后会将保存在Livedata中的数据拿出来重新展示，无需再另做数据保存
            mainViewModelManager.getNHData()

//            var list = retrofitNHManager.retrofitAPI.getNHList()
//            list.observe(this@MainActivity, Observer {
//                if (it.resultState == ResultState.LOADING) {
//                    testTV.text = "正在加载数据"
//                } else if (it.resultState == ResultState.ERROR) {
//                    testTV.text = "数据加载错误"
//                } else if (it.resultState == ResultState.SUCCESS) {
//                    testTV.text = "返回" + it.data.size + "条数据"
//                }
//            })

            /*  不使用LiveData和ViewModel时直接清收是如下方式
              GlobalScope.launch(Dispatchers.IO) {
                   var baseBaen = RetrofitManager.getNHList()
                   GlobalScope.launch(Dispatchers.Main) {
                       testTV.text = "普通返回" + baseBaen.data.size + "条数据"
                   }
            */
        }

    }


}


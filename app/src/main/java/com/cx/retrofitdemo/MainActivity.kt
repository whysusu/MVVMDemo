package com.cx.retrofitdemo


import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cx.retrofitdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
     var  firstFragment = manager.findFragmentById(R.id.firstFrag) as FirstFragment
     var  secondFragment = manager.findFragmentById(R.id.secFrag) as SecondFragment
//
//        //从kodein中拿到RetrofitNHManager的对象
//        val retrofitAPI:RetrofitAPI by instance<RetrofitAPI>()
//        var mainViewModelManager = MainViewModelManager(this,retrofitAPI)
//
//        mainViewModelManager.nhLiveData.observe(this, Observer {
//            if (it.resultState == ResultState.LOADING) {
//                testTV.text = "正在加载数据"
//            } else if (it.resultState == ResultState.ERROR) {
//                testTV.text = "数据加载错误"
//            } else if (it.resultState == ResultState.SUCCESS) {
//                testTV.text = "返回" + it.data.size + "条数据"
//            }
//        })


        Button.setOnClickListener {
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.hide(secondFragment)
            transaction.show(firstFragment)
            transaction.commit()
        }

        Button2.setOnClickListener {
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.hide(firstFragment)
            transaction.show(secondFragment)
            transaction.commit()
        }
    }


}


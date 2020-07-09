package com.cx.retrofitdemo

import android.annotation.SuppressLint
import android.app.Application
import com.cx.retrofitdemo.modules.httpClientModule
import com.cx.retrofitdemo.modules.serviceModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

/**
 * @ClassName: RetrofitApplication
 * @Author: CX
 * @Date: 2020/6/24 16:32
 */
class RetrofitApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidModule(this@RetrofitApplication))
        import(httpClientModule)//这里将网络请求相关的初始化依赖到项目中
        import(serviceModule)//这里是请求相关APIService
    }

    /**
     * 单例
     * **/
    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: RetrofitApplication? = null
            get() {
                if (field == null) {
                    field = RetrofitApplication()
                }
                return field
            }

        @Synchronized
        fun get(): RetrofitApplication? {
            return instance
        }

    }

    override fun onCreate() {
        super.onCreate()
    }


}
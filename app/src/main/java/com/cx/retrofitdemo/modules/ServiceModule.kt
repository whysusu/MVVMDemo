package com.cx.retrofitdemo.modules

import com.cx.retrofitdemo.RetrofitAPI
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

/**
 * @ClassName: ServiceModule
 * @Author: CX
 * @Date: 2020/7/2 9:22
 */

const val SERVICE_MODULE_TAG = "serviceModule"
val serviceModule = Kodein.Module(SERVICE_MODULE_TAG) {
    bind<RetrofitAPI>() with singleton { instance<Retrofit>().create(RetrofitAPI::class.java) }

}
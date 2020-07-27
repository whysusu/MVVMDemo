package com.cx.retrofitdemo


import androidx.annotation.AnyThread
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cx.retrofitdemo.httpclient.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @ClassName: RetrofitManager
 * @Author: CX
 * @Date: 2020/6/24 15:13
 */
object RetrofitManager {
    var NewHouseURl = "http://newhouseapi.t.jjw.com/"
    var baseUrl: String = "http://appapi.t.jjw.com/"
    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()
    }

    private var retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl(NewHouseURl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHttpClient())
        .build()
    val retrofitApi: RetrofitAPI by lazy { retrofit.create(RetrofitAPI::class.java) }


}
package com.cx.retrofitdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

/**
 * @ClassName: RetrofitRequest
 * @Author: CX
 * @Date: 2020/6/24 15:23
 */
const val nhUrl="/api/Home/SelectRecommendHouse"

interface RetrofitAPI {

    @GET("/api/Home/SelectRecommendHouse")
    suspend fun <T> getNHList(): BaseBean<T>

    @GET
    suspend fun <T> getBaseBean(@Url url:String, @QueryMap map:HashMap<String,String>): BaseBean<T>

    @GET
    suspend fun <T> getBaseBean(@Url url:String): BaseBean<T>
}


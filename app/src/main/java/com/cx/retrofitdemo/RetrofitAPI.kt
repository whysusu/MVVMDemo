package com.cx.retrofitdemo

import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import okhttp3.ResponseBody

import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

/**
 * @ClassName: RetrofitRequest
 * @Author: CX
 * @Date: 2020/6/24 15:23
 */
const val nhUrl = "/api/Home/SelectRecommendHouse"
const val nhDetailsUrl = "/api/NewHouse/GetBuilgingInfo"

interface RetrofitAPI {

    @GET("/api/Home/SelectRecommendHouse")
    suspend fun <T> getNHList(): BaseBean<T>

    @GET
    suspend fun getBaseBean(
        @Url url: String,
        @QueryMap map: HashMap<String, String>
    ): ResponseBody

    @GET
    suspend fun  getBaseBean(@Url url: String): ResponseBody

}


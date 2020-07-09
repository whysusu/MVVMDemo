package com.cx.retrofitdemo.httpclient

import com.cx.retrofitdemo.Constants
import com.cx.retrofitdemo.utils.KotlinUtils
import com.blankj.utilcode.util.DeviceUtils
import com.blankj.utilcode.util.SPUtils
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by chengxiao on 2018/10/17.
 * 设置请求头
 */
class HeaderInterceptor : Interceptor {
    private var owinUid: String = ""

    override fun intercept(chain: Interceptor.Chain): Response {
        var original: Request = chain.request()
        var headers: Headers.Builder = original.headers().newBuilder()
        var owinRand: String = KotlinUtils.getRandom()
        var owinTs: String = ("" + System.currentTimeMillis()).substring(0, 10)

        owinUid = KotlinUtils.getUniquePsuedoID()

        val sign = KotlinUtils.getSign(owinRand, owinTs, owinUid, Constants.SECURITY_KEYVAULE)
        headers.add(Constants.OWIN_REQUESTT, Constants.PLATFORM)
        headers.add(Constants.OWIN_UID, owinUid)    //设置设备编号
        headers.add(Constants.OWIN_RAND, owinRand)  //随机数
        headers.add(Constants.OWIN_SIGN, sign)      //签名
        headers.add(Constants.OWIN_TS, owinTs)      //10位的时间时间戳数字   UTC
        headers.add(Constants.OWIN_MAC, DeviceUtils.getMacAddress())
        headers.add(Constants.OWIN_CITY, SPUtils.getInstance().getInt("city_id", 1).toString() + "")   //城市ID（暂时默认为武汉）
        headers.add(Constants.OWIN_VERSION, Constants.VERSIONONE)

        var request: Request = original.newBuilder().headers(headers.build()).build()
        return chain.proceed(request)

    }
}
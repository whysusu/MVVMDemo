package com.cx.retrofitdemo.modules

import com.cx.retrofitdemo.httpclient.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @ClassName: HttpClientModule
 * @Author: CX
 * @Date: 2020/7/1 15:23
 */
const val HTTP_CLIENT_MODULE_TAG = "httpClientModule"
const val HTTP_CLIENT_MODULE_INTERCEPTOR_AUTH_TAG = "http_client_module_interceptor_auth_tag"
const val NewHouseURl = "http://newhouseapi.t.jjw.com/"
const val BASE_URL: String = "http://appapi.t.jjw.com/"


/**这里是网络请求相关的初始化，统一在这里当到Kodein中，在Application中注入依赖**/
var httpClientModule = Kodein.Module(HTTP_CLIENT_MODULE_TAG) {

    bind<Retrofit.Builder>() with provider { Retrofit.Builder() }

    bind<OkHttpClient.Builder>() with provider { OkHttpClient.Builder() }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl(NewHouseURl)
            .client(instance())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    bind<Interceptor>(HTTP_CLIENT_MODULE_INTERCEPTOR_AUTH_TAG) with singleton { HeaderInterceptor() }


    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>()
            .addInterceptor(instance<Interceptor>(HTTP_CLIENT_MODULE_INTERCEPTOR_AUTH_TAG))
            .build()
    }
}
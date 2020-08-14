package com.cx.retrofitdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.tools.build.jetifier.core.utils.Log
import com.cx.retrofitdemo.RetrofitAPI
import com.cx.retrofitdemo.RetrofitManager
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.NewHouseBean
import com.cx.retrofitdemo.nhDetailsUrl
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.reflect.Type

/**
 * @ClassName: DetailViewModel
 * @Author: CX
 * @Date: 2020/8/14 11:39
 */
class DetailViewModel constructor(retrofitAPI: RetrofitAPI) : BaseViewModel(retrofitAPI) {

    val nhDetailsLiveData by lazy { MutableLiveData<BaseBean<NewHouseBean.Data>>() }

    //新房详情接口
    fun getNHDetails() {
        val objectType: Type = object : TypeToken<BaseBean<NewHouseBean.Data>>() {}.type
        var baseBean = BaseBean(data = NewHouseBean.Data())
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var parameters = HashMap<String, String>()
                parameters["id"] = "3012"
                var nhBean =
                    getBaseData(
                        RetrofitManager.NewHouseURl + nhDetailsUrl,
                        parameters,
                        objectType,
                        baseBean
                    )
                nhDetailsLiveData.postValue(nhBean)
            }
        }
    }
}

class DetailViewModelManagerFactory(private val retrofitAPI: RetrofitAPI) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(retrofitAPI) as T
    }

}
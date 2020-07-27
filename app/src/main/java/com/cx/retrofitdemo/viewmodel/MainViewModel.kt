package com.cx.retrofitdemo.viewmodel

import androidx.lifecycle.*
import com.cx.retrofitdemo.RetrofitAPI
import com.cx.retrofitdemo.RetrofitManager.NewHouseURl
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import com.cx.retrofitdemo.bean.NewHouseBean
import com.cx.retrofitdemo.nhDetailsUrl
import com.cx.retrofitdemo.nhUrl
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.reflect.Type

/**
 * @ClassName: MainViewModelManager 这里必须要继承BaeViewModel才能实现不同fragment数据共享
 * @Author: CX
 * @Date: 2020/7/8 16:46
 */
class MainViewModel(retrofitAPI: RetrofitAPI) : BaseViewModel(retrofitAPI) {
    init {
        //在初始化中就去调用已进入页面就要展示的数据，这样在横竖屏借切换等情况下会保持数据不变
        getNHDetails()
    }

    val nhLiveData by lazy { MutableLiveData<BaseBean<MutableList<IndexPreferredDataBean>>>() }
    val nhDetailsLiveData by lazy { MutableLiveData<BaseBean<NewHouseBean.Data>>() }
    fun getNHData() {

        //这里一定要提前知道需要解析的实体类型，从这里把类型传到基类中才能解析出相对应的实体类型，
        // 若直接在基类中使用T解析会出现linkedtreemap cannot be cast to xxx的异常
        val objectType: Type =
            object : TypeToken<BaseBean<MutableList<IndexPreferredDataBean>>>() {}.type
        var baseBean = BaseBean(data = mutableListOf<IndexPreferredDataBean>())
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var baseBean =
                    getBaseData<MutableList<IndexPreferredDataBean>>(
                        NewHouseURl + nhUrl,
                        null,
                        objectType,
                        baseBean
                    )
                nhLiveData.postValue(baseBean)
            }
        }
    }



    //新房详情接口
    fun getNHDetails() {
        val objectType: Type = object : TypeToken<BaseBean<NewHouseBean.Data>>() {}.type
        var baseBean = BaseBean(data = NewHouseBean.Data())

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var parameters = HashMap<String, String>()
                parameters["id"] = "3012"
                var nhBean =
                    getBaseData(NewHouseURl + nhDetailsUrl, parameters, objectType, baseBean)
                nhDetailsLiveData.postValue(nhBean)

            }
        }
    }
}

class MainViewModelManagerFactory(
    private val retrofitAPI: RetrofitAPI
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(retrofitAPI) as T
    }
}
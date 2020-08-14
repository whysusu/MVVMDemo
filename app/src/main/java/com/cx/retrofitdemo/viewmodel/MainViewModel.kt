package com.cx.retrofitdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cx.retrofitdemo.OptimizationHouseUrl
import com.cx.retrofitdemo.RetrofitAPI
import com.cx.retrofitdemo.RetrofitManager.NewHouseURl
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import com.cx.retrofitdemo.bean.NewHouseBean
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.modules.BASE_URL
import com.cx.retrofitdemo.nhDetailsUrl
import com.cx.retrofitdemo.nhUrl
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.reflect.Type
import kotlin.collections.set

/**
 * @ClassName: MainViewModelManager 这里必须要继承BaeViewModel才能实现不同fragment数据共享
 * @Author: CX
 * @Date: 2020/7/8 16:46
 */
class MainViewModel constructor(retrofitAPI: RetrofitAPI) : BaseViewModel(retrofitAPI) {
    var refreshing = MutableLiveData<Boolean>()
    val nhLiveData by lazy { MutableLiveData<BaseBean<MutableList<IndexPreferredDataBean>>>() }
    val esLiveData by lazy { MutableLiveData<BaseBean<MutableList<IndexPreferredDataBean>>>() }
    val czLiveData by lazy { MutableLiveData<BaseBean<MutableList<IndexPreferredDataBean>>>() }
    val titleLiveData by lazy { MutableLiveData<MutableList<String>>() }
    var titleData = mutableListOf<String>()

    val objectType: Type =
        object : TypeToken<BaseBean<MutableList<IndexPreferredDataBean>>>() {}.type
    var baseBean = BaseBean(data = mutableListOf<IndexPreferredDataBean>())

    init {
        //在初始化中就去调用已进入页面就要展示的数据，这样在横竖屏借切换等情况下会保持数据不变
        getHouseListData()
        titleData.clear()
    }

    private fun getHouseListData() {
        //这里一定要提前知道需要解析的实体类型，从这里把类型传到基类中才能解析出相对应的实体类型，
        // 若直接在基类中使用T解析会出现linkedtreemap cannot be cast to xxx的异常

        viewModelScope.launch {
            //创建新的协程请求默认列表接口
            var housetype = 0
            var pramars = HashMap<String, String>()
            pramars["houseType"] = "" + housetype
            var defaultListBean =
                withContext(Dispatchers.IO) {
                    getBaseData<MutableList<IndexPreferredDataBean>>(
                        BASE_URL + OptimizationHouseUrl,
                        pramars,
                        objectType,
                        baseBean
                    )
                }
            Log.i("cx-----列表返回顺序", "这里返回默认值列表1")


            if (defaultListBean.data != null && defaultListBean.data.size > 0) {
                housetype = if (defaultListBean.data[0].houseType == 2) {
                    titleData.add("二手房")
                    esLiveData.postValue(defaultListBean)
                    titleLiveData.postValue(titleData)
                    3
                } else {
                    titleData.add("出租房")
                    czLiveData.postValue(defaultListBean)
                    titleLiveData.postValue(titleData)
                    2
                }
            }
            Log.i("cx-----titleData", "" + titleData.size)
            Log.i("cx-----titleLiveData", "" + titleLiveData.value?.size)


            //等默认列表接口请求完成之后去请求另一个接口
            if (housetype > 0) {
                pramars["houseType"] = "" + housetype
                var otherListBean =
                    withContext(Dispatchers.IO) {
                        getBaseData<MutableList<IndexPreferredDataBean>>(
                            BASE_URL + OptimizationHouseUrl,
                            pramars,
                            objectType,
                            baseBean
                        )
                    }
                if (otherListBean.data.size == 0) {
                    otherListBean.resultState = ResultState.EMPTY
                }

                if (housetype == 2 && otherListBean.data != null && otherListBean.data.size > 0) {
                    titleData.add("二手房")
                    esLiveData.postValue(otherListBean)
                    titleLiveData.postValue(titleData)
                } else if (housetype == 3) {
                    titleData.add("出租房")
                    czLiveData.postValue(otherListBean)
                    titleLiveData.postValue(titleData)
                }
            }
            Log.i("cx-----列表返回顺序", "这里返回默认值列表2")
            Log.i("cx-----titleData", "" + titleData.size)
            Log.i("cx-----titleLiveData", "" + titleLiveData.value?.size)
            refreshing.postValue(false)

        }

        viewModelScope.launch {
            //创建新的协程请求新房列表接口
            viewModelScope.async(Dispatchers.IO) {
                var baseBean =
                    getBaseData<MutableList<IndexPreferredDataBean>>(
                        NewHouseURl + nhUrl,
                        null,
                        objectType,
                        baseBean
                    )
                if (baseBean.data.size == 0) {
                    baseBean.resultState = ResultState.EMPTY
                }
                nhLiveData.postValue(baseBean)
                if (baseBean.data != null && baseBean.data.size > 0) {
                    titleData.add("新房")
                    titleLiveData.postValue(titleData)
                }
                Log.i("cx-----列表返回顺序", "这里返回新房列表")
                Log.i("cx-----titleData", "" + titleData.size)
                Log.i("cx-----titleLiveData", "" + titleLiveData.value?.size)
            }

        }


    }


    private fun getHouseData() {
        var housetype = 0
        var pramars = HashMap<String, String>()
        pramars["houseType"] = "" + housetype
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var baseBean =
                    getBaseData<MutableList<IndexPreferredDataBean>>(
                        BASE_URL + OptimizationHouseUrl,
                        pramars,
                        objectType,
                        baseBean
                    )

                if (baseBean.data != null && baseBean.data.size > 0) {
                    if (baseBean.data[0].houseType == 2 && housetype == 0) {
                        esLiveData.postValue(baseBean)
                        getOtherHouse(3)
                    } else {
                        czLiveData.postValue(baseBean)
                        getOtherHouse(2)

                    }
                } else {
                    esLiveData.postValue(baseBean)
                    czLiveData.postValue(baseBean)
                }
            }
        }
    }


    fun getOtherHouse(i: Int) {
        var pramars = HashMap<String, String>()
        pramars["houseType"] = "" + i
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var baseBean =
                    getBaseData<MutableList<IndexPreferredDataBean>>(
                        BASE_URL + OptimizationHouseUrl,
                        pramars,
                        objectType,
                        baseBean
                    )
                if (i == 2) {
                    esLiveData.postValue(baseBean)
                } else if (i == 3) {
                    czLiveData.postValue(baseBean)
                }
            }
        }
    }



    fun onRefresh() {
        Log.i("cx----","好的"+123)
        refreshing.value=true
        getHouseListData()

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
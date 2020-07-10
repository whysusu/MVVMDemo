package com.cx.retrofitdemo.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.cx.retrofitdemo.RetrofitAPI
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import com.cx.retrofitdemo.nhUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @ClassName: MainViewModelManager 这里必须要继承BaeViewModel才能实现不同fragment数据共享
 * @Author: CX
 * @Date: 2020/7/8 16:46
 */
class MainViewModel(retrofitAPI: RetrofitAPI) : BaseViewModel(retrofitAPI) {
    val nhLiveData by lazy { MutableLiveData<BaseBean<IndexPreferredDataBean>>() }
    fun getNHData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var baseBean = getBaseData<IndexPreferredDataBean>(nhUrl)
                nhLiveData.postValue(baseBean)
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
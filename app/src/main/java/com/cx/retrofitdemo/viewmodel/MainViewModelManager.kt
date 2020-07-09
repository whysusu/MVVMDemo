package com.cx.retrofitdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import com.cx.retrofitdemo.RetrofitAPI
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import com.cx.retrofitdemo.nhUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @ClassName: MainViewModelManager
 * @Author: CX
 * @Date: 2020/7/8 16:46
 */
class MainViewModelManager(owner: ViewModelStoreOwner, retrofitAPI: RetrofitAPI) {
    val nhViewModel: BaseViewModel = ViewModelProvider(owner,BaseViewModelFactory(retrofitAPI)).get(BaseViewModel::class.java)
    var nhLiveData = MutableLiveData<BaseBean<IndexPreferredDataBean>>()
    fun getNHData() {
        nhViewModel.viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var baseBean = nhViewModel.getBaseData<IndexPreferredDataBean>(nhUrl)
                nhLiveData.postValue(baseBean)
            }
        }
    }
}

package com.cx.retrofitdemo.viewmodel

import androidx.lifecycle.*
import com.blankj.utilcode.util.ToastUtils
import com.cx.retrofitdemo.*
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.ResultState

/**
 * @ClassName: NHViewModel
 * @Author: CX
 * @Date: 2020/7/2 10:32
 */
class BaseViewModel(var retrofitAPI: RetrofitAPI) : ViewModel() {

    suspend fun <T> getBaseData(url:String,map: HashMap<String, String>?=null): BaseBean<T> {
        return requestHttpFromIO<T>(url, map)

    }

    /**这里处理请求中返回的公共部分，来判断数据返回的状态**/
    suspend fun <T> requestHttpFromIO(url: String, map: HashMap<String, String>?): BaseBean<T> {

        var baseBean = BaseBean<T>()
        baseBean.resultState = ResultState.LOADING
        try {
            baseBean =
                if(map==null){
                    retrofitAPI.getBaseBean<T>(url)
                }else{
                    retrofitAPI.getBaseBean<T>(url, map)
                }

            if (baseBean.code == 2000) {
                if (baseBean.data != null) {
                    baseBean.resultState = ResultState.SUCCESS

                } else {
                    baseBean.resultState = ResultState.EMPTY
                }
            } else {
                baseBean.resultState = ResultState.ERROR
                ToastUtils.showShort(baseBean.errors)
            }
        } catch (e: Exception) {
            ToastUtils.showShort(e.message)
            baseBean.resultState = ResultState.ERROR
        }
        return baseBean
    }

}


class BaseViewModelFactory(
    private val retrofitAPI: RetrofitAPI
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BaseViewModel(retrofitAPI) as T
    }
}
package com.cx.retrofitdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.ToastUtils
import com.cx.retrofitdemo.RetrofitAPI
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.NewHouseBean
import com.cx.retrofitdemo.bean.ResultState
import com.cx.retrofitdemo.utils.GsonUtils
import java.lang.reflect.Type


/**
 * @ClassName: NHViewModel
 * @Author: CX
 * @Date: 2020/7/2 10:32
 */
open class BaseViewModel(var retrofitAPI: RetrofitAPI) : ViewModel() {

    suspend fun <T> getBaseData(
        url: String,
        map: HashMap<String, String>? = null,
        type: Type,
        baseBean: BaseBean<T>
    ): BaseBean<T> {
        return requestHttpFromIO(url, map, type, baseBean)

    }

    /**这里处理请求中返回的公共部分，来判断数据返回的状态**/
    private suspend fun <T> requestHttpFromIO(
        url: String,
        map: HashMap<String, String>?,
        type: Type,
        baseBean: BaseBean<T>
    ): BaseBean<T> {
        var resultBean = baseBean
        resultBean.resultState = ResultState.LOADING

        var jsonBean = ""
        try {
            jsonBean = if (map == null) {
                retrofitAPI.getBaseBean(url).string()

            } else {
                retrofitAPI.getBaseBean(url, map).string()

            }
            //这里一定要提前知道需要解析的实体类型，从子ViewModel中把类型type传到基类中才能解析出相对应的实体类型，
            // 若直接在基类中使用T解析会出现linkedtreemap cannot be cast to xxx的异常
            resultBean = GsonUtils.toBean(jsonBean, type)!!
            if (resultBean.code == 2000) {
                if (resultBean.data != null) {
                    resultBean.resultState = ResultState.SUCCESS

                } else {
                    resultBean.resultState = ResultState.EMPTY
                }
            } else {
                resultBean.resultState = ResultState.ERROR
                ToastUtils.showShort(baseBean.errors)

            }
        } catch (e: Exception) {
            ToastUtils.showShort(e.message)
            Log.i("cx---", e.message)
            resultBean.resultState = ResultState.ERROR
        }
        return resultBean
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
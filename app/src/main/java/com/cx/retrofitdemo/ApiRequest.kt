package com.cx.retrofitdemo


import com.blankj.utilcode.util.ToastUtils
import com.cx.retrofitdemo.bean.BaseBean
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import com.cx.retrofitdemo.bean.ResultState
import org.kodein.di.android.retainedKodein


/**
 * @ClassName: ApiRequest
 * @Author: CX
 * @Date: 2020/7/3 11:31
 */
class ApiRequest() {


    /**这里处理请求中返回的公共部分，来判断数据返回的状态**/
    suspend fun <T> requestHttpListFromIO(url: String): BaseBean<String> {
        var baseBean = BaseBean<String>(data = "")
        baseBean.resultState = ResultState.LOADING
        try {
//            baseBean = withContext(Dispatchers.IO) {}
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


    /**这里来调用公共接口，将自己需要返回的类型传到公共请求中**/
    suspend fun getNHList(url:String): BaseBean<String> {

        var beanList =
            requestHttpListFromIO<IndexPreferredDataBean>(url)

        //这里使用IO线程来请求数据
        return beanList
    }


//    suspend fun getNHListLiveData(): MutableLiveData<BaseBean<IndexPreferredDataBean>> {
//        //这里使用IO线程来请求数据
//        return withContext(Dispatchers.IO) { retrofitNHManager.retrofitAPI.getNHList() }
//    }

}
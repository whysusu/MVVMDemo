package com.cx.retrofitdemo.bean
import com.google.gson.annotations.SerializedName


/**
 * @ClassName: BaseBean
 * @Author: CX
 * @Date: 2020/7/9 11:04
 */
data class BaseBean<T>(
    @SerializedName("Code")
    val code: Int = 0, // 2000
    @SerializedName("Data")
    val `data`: List<T> = listOf(),
    @SerializedName("Errors")
    val errors: String = "", // null
    @SerializedName("Msg")
    val msg: String = "", // 请求成功!
    @SerializedName("PM")
    val pM: PM = PM(),
    @SerializedName("Success")
    val success: Boolean = false, // true
    var resultState :ResultState= ResultState.DEFAULT
) {
    data class PM(
        @SerializedName("PageCount")
        val pageCount: Int = 0, // 8
        @SerializedName("PageIndex")
        val pageIndex: Int = 0, // 1
        @SerializedName("PageSize")
        val pageSize: Int = 0, // 10
        @SerializedName("TotalCount")
        val totalCount: Int = 0 // 79
    )
}
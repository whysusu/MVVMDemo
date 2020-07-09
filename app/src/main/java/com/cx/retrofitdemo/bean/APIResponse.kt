package com.cx.retrofitdemo.bean


/**
 * @ClassName: APIResponse
 * @Author: CX
 * @Date: 2020/7/7 14:48
 */
public class APIResponse<T> {
    val CODE_SUCCESS = 0
    val CODE_ERROR = 1

    var code //状态码
            = 0
    var msg //信息
            : String? = null
    var data //数据
            : T? = null

    fun ApiResponse(code: Int, msg: String?) {
        this.code = code
        this.msg = msg
        data = null
    }

    fun ApiResponse(code: Int, msg: String?, data: T?) {
        this.code = code
        this.msg = msg
        this.data = data
    }
}
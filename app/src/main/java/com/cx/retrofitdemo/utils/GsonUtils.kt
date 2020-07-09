package com.cx.retrofitdemo.utils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

/**
 * Created by chengxiao on 2018/10/18.
 */
class GsonUtils {
    companion object {
        fun <T> toBean(json: String, type: Class<T>): T? {
            return try {
                Gson().fromJson(json, type)
            } catch (e: JsonSyntaxException) {
                null
            }

        }

        /**
         * @param obj
         * @return
         */
        fun toJson(obj: Any): String {
            return Gson().toJson(obj)
        }


    }
}
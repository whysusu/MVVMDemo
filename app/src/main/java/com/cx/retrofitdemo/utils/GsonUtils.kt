package com.cx.retrofitdemo.utils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.internal.`$Gson$Types`
import com.google.gson.reflect.TypeToken
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


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

        fun <T> toBean (json: String, type: Type):T? {
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




        fun getSuperclassTypeParameter(subclass: Type): Type? {
            if (subclass is Class<*>) {
                throw RuntimeException("Missing type parameter.")
            }
            val parameterized =
                subclass as ParameterizedType?
            return `$Gson$Types`
                .canonicalize(parameterized!!.actualTypeArguments[0])
        }

    }


}


class ParameterizedTypeImpl(
    private var raw: Class<*>,
    private var args: Array<Type>
) :
    ParameterizedType {

    init {
        this.raw = raw
        this.args = args
    }

    override fun getRawType(): Type {
        return raw
    }

    override fun getOwnerType(): Type? {
        return null
    }

    override fun getActualTypeArguments(): Array<Type> {
        return args
    }
}


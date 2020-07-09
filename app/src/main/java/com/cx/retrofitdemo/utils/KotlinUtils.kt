package com.cx.retrofitdemo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build


import android.util.Pair
import android.widget.ImageView
import com.cx.retrofitdemo.Constants

import com.blankj.utilcode.util.EncryptUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by chengxiao on 2018/10/17.
 * 工具类
 */
class KotlinUtils {
    // companion object包裹范围内 属于静态方法
    companion object {

        /**
         * 获取随机数
         */
        fun getRandom(): String {
            var randString: String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            var charArray = randString.toCharArray()
            var stringBuilder: StringBuilder = StringBuilder()
            var random: Random = Random(System.currentTimeMillis())

            //随机5 - 10位的随机数
            for (i in 0..random.nextInt(5) + 5) {
                val randomIndex = random.nextInt(charArray.size)
                stringBuilder.append(charArray[randomIndex])
            }
            return stringBuilder.toString()
        }

        /**
         *  获得独一无二的Psuedo ID
         */
        fun getUniquePsuedoID(): String {
            var serial: String?
            val m_szDevIDShort = "35" +
                    Build.BOARD.length % 10 + Build.BRAND.length % 10 +
                    Build.CPU_ABI.length % 10 + Build.DEVICE.length % 10 +
                    Build.DISPLAY.length % 10 + Build.HOST.length % 10 +
                    Build.ID.length % 10 + Build.MANUFACTURER.length % 10 +
                    Build.MODEL.length % 10 + Build.PRODUCT.length % 10 +
                    Build.TAGS.length % 10 + Build.TYPE.length % 10 +
                    Build.USER.length % 10 //13 位
            try {
                serial = android.os.Build::class.java.getField("SERIAL").get(null).toString()
                //API>=9 使用serial号
                return UUID(m_szDevIDShort.hashCode().toLong(), serial.hashCode().toLong()).toString()
            } catch (exception: Exception) {
                //serial需要一个初始化
                serial = "serial" // 随便一个初始化
            }

            //使用硬件信息拼凑出来的15位号码
            return UUID(m_szDevIDShort.hashCode().toLong(), serial!!.hashCode().toLong()).toString()
        }

        /**
         * 获取签名
         */
        fun getSign(owinRand: String, owinTs: String, owinUid: String, securityKey: String): String {
            val params = TreeSet(Comparator<Pair<String, String>> { o1, o2 -> o1.first.compareTo(o2.first) })
            params.add(Pair(Constants.OWIN_RAND, owinRand))
            params.add(Pair(Constants.OWIN_TS, owinTs))
            params.add(Pair(Constants.OWIN_UID, owinUid))
            params.add(Pair(Constants.SECURITY_KEY, securityKey))

            val stringBuilder = StringBuilder()
            for (pair in params) {
                stringBuilder.append(pair.first).append("=").append(pair.second).append("&")
            }
            stringBuilder.deleteCharAt(stringBuilder.length - 1)

            return EncryptUtils.encryptMD5ToString(stringBuilder.toString().toByteArray()).toLowerCase()
        }


        fun LoadImage(context: Context, defimage: Int, url: Any, view: ImageView) {
            try {
                val options = RequestOptions()
                options.placeholder(defimage)

                Glide.with(context)
                        .load(url)
                        .apply(options)
                        .into(view)
            } catch (e: Exception) {

            }
        }

        fun LoadRoundImage(context: Context, defimage: Int, url: Any, view: ImageView) {
            try {
                val options = RequestOptions()
                options.circleCrop().placeholder(defimage)

                Glide.with(context)
                        .load(url)
                        .apply(options)
                        .into(view)
            } catch (e: Exception) {

            }
        }

        /**
         * double转换字符串(保留2位小数)
         *
         * @param value
         * @return
         */
        fun formatNum(value: Double): String {
            try {
                val df = DecimalFormat("###########.##")
                return getCount(df.format(value))
            } catch (e: Exception) {

            }

            return ""
        }

        /**
         * 不使用科学计数法
         *
         * @param d
         * @return
         */
        fun getCount(d: String): String {
            val bg = BigDecimal(d)
            return bg.toPlainString()
        }

        /**
         * double转换字符串(保留1位小数)
         *
         * @param value
         * @return
         */
        fun formatNumOne(value: Double): String {
            try {
                val df = DecimalFormat("###########.#")
                return getCount(df.format(value))
            } catch (e: Exception) {

            }

            return ""
        }



        @SuppressLint("SimpleDateFormat")
                /**
                 * 获取当前时间
                 *
                 * @return
                 */
        fun getCurTime(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }

        /**
         * String 转换 Date
         *
         * @param str
         * @return
         */
        @SuppressLint("SimpleDateFormat")
        fun string2Date(str: String): Date {
            try {
                return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return Date()
        }

    }
}
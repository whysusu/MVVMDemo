package com.cx.retrofitdemo.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cx.retrofitdemo.R

/**
 * @ClassName: ImageViewAttrAdapter  databinding配合GLide使用 管理类
 * @Author: CX
 * @Date: 2020/8/4 11:10
 */
class ImageViewAttrAdapter {
    companion object {
        @BindingAdapter(value = ["app:url", "app:holderResId"])//value后面可自定义自己需要的属性
        @JvmStatic //kotlin的话，除了 @BindingAdapter("XXX") 注解之外必须还要加上 @JvmStatic，不然会报错
        fun loadImageView(imageView: ImageView, url: String, holderResId: Drawable) {
            val options = RequestOptions()
            options.placeholder(holderResId)
            options.error(R.mipmap.photo)
            options.useAnimationPool(false)
            Glide.with(imageView.context).load(url).apply(options).into(imageView)
        }
    }
}
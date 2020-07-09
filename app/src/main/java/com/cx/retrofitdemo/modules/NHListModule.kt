package com.cx.retrofitdemo.modules

import android.app.Activity
import androidx.lifecycle.LifecycleOwner

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

/**
 * @ClassName: NHListModule
 * @Author: CX
 * @Date: 2020/7/2 10:41
 */
const val NH_LIST_MODULE_TAG = "nhListModule"
val nhListModule = Kodein.Module(NH_LIST_MODULE_TAG){
//    bind<NHViewModel>() with scoped<Activity>()
}
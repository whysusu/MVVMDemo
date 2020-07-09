package com.cx.retrofitdemo.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein

/**
 * @ClassName: BaseActivity
 * @Author: CX
 * @Date: 2020/7/2 10:09
 */
abstract class BaseActivity() : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by retainedKodein { extend(parentKodein, copy = Copy.All) }
    val parentKodein by closestKodein()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }

}
package com.cx.retrofitdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

/**
 * @ClassName: FourthFragment
 * @Author: CX
 * @Date: 2020/7/30 14:13
 */
class FourthFragment : Fragment(), KodeinAware {

    companion object{
        val instance by lazy { FourthFragment() }
    }
    val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy { extend(parentKodein, copy = Copy.All) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var contentView = inflater.inflate(R.layout.frg_fourth, null)
        return contentView
    }

}
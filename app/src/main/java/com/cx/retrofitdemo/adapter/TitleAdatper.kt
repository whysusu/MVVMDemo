package com.cx.retrofitdemo.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cx.retrofitdemo.R


/**
 * @ClassName: TitleAdatper
 * @Author: CX
 * @Date: 2020/8/3 10:25
 */
class TitleAdatper :BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_title){
    override fun convert(holder: BaseViewHolder, item: String) {
       holder.getView<TextView>(R.id.titleTV) .text=item
    }
}
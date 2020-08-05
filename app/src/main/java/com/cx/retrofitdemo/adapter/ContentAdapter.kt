package com.cx.retrofitdemo.adapter

import android.widget.TextView
import com.blankj.utilcode.util.StringUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cx.retrofitdemo.R
import com.cx.retrofitdemo.bean.IndexPreferredDataBean
import com.cx.retrofitdemo.databinding.ItemContentBinding
import com.cx.retrofitdemo.utils.KotlinUtils

/**
 * @ClassName: ContentAdapter
 * @Author: CX
 * @Date: 2020/8/4 9:42
 */
class ContentAdapter :
    BaseQuickAdapter<IndexPreferredDataBean, BaseDataBindingHolder<ItemContentBinding>>(R.layout.item_content) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemContentBinding>,
        item: IndexPreferredDataBean
    ) {
        var itemContentBinding = holder.dataBinding
        if (itemContentBinding != null) {
            itemContentBinding.houseList = item
            itemContentBinding.executePendingBindings()
        }
        //是否是VR房源
        val orientation =
            if (StringUtils.isEmpty(item.orientationName)) "" else "/" + item.orientationName
        val area_sq =
            "/" + item.areaName.toString() + "  " + item.shangQuanName
        var houseType = (item.countF.toString() + "室"
                + item.countT + "厅/"
                + KotlinUtils.formatNum(item.producingArea) + "㎡"
                + orientation + area_sq)
        holder.getView<TextView>(R.id.tv_house_type).text = houseType
    }


}
package com.lnkj.wzhr.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import com.lz.zergling.R
import com.lz.zergling.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_unfit.*
import org.jetbrains.anko.windowManager


/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
class UnfitDialog(var mContext: Context) : BaseDialog(mContext) {

    override val layoutRes: Int
        get() = R.layout.dialog_unfit

    override fun initLogic() {

    }

    override fun setListener() {
        btn.setOnClickListener { dismiss() }
    }

    override fun processLogic() {

    }


    fun initAll() {
        btn.setOnClickListener { dismiss() }
    }
}
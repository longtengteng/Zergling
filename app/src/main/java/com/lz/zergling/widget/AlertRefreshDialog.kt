package com.lnkj.wzhr.widget

import android.content.Context
import android.view.ViewGroup
import com.lz.zergling.R
import com.lz.zergling.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_alert_refresh.*
import org.jetbrains.anko.windowManager

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
class AlertRefreshDialog(var mContext: Context, var title: String, var content: String, var mActionListener: ((index: Int) -> Unit)?) : BaseDialog(mContext) {
    override val layoutRes: Int
        get() = R.layout.dialog_alert_refresh

    override fun show() {
        super.show()
        // 将对话框的大小按屏幕大小的百分比设置
        val windowManager = context.windowManager
        val display = windowManager.defaultDisplay
        val lp = window.attributes
        lp.width = (display.width * 0.9).toInt() //设置宽度
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
        window.attributes = lp
    }

    override fun initLogic() {
        tv_refresh_time.text = title
        tv_content.text = content
        tv_cancel.text = "稍后再说"
        tv_certain.text = "刷新简历"
    }

    override fun setListener() {
        tv_cancel.setOnClickListener { dismiss() }
        tv_certain.setOnClickListener {
            mActionListener?.invoke(0)
            dismiss()
        }
    }

    override fun processLogic() {

    }
}
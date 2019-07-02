package com.lnkj.wzhr.base

import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import com.lz.zergling.MyApplication
import com.lz.zergling.R
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.inputMethodManager

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
abstract class BaseActivity<out P : BasePresent<*>> : AppCompatActivity() {

    protected val TAG = javaClass.simpleName
    protected var dialog: ProgressDialog? = null
    protected lateinit var mContext: Context
    abstract val mPresenter: P
    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        mContext = this
        MyApplication.getInstance().addActivity(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        initView()
    }

    private fun initView() {
        initLogic()
        setListener()
        processLogic()
    }

    protected abstract fun initLogic()
    protected abstract fun setListener()
    protected abstract fun processLogic()

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    protected fun hideSoftKeyboard(view: View) {
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    protected fun showSoftKeyboard(view: View) {
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }

    protected fun initDialog() {
        dialog = ProgressDialog(mContext)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog?.setMessage(mContext.getString(R.string.connecting))
    }

    protected fun showDialog() {
        if (dialog != null && !(dialog?.isShowing ?: false))
            dialog?.show()
    }

    protected fun hideDialog() {
        if (dialog != null && dialog?.isShowing ?: false)
            dialog?.dismiss()
    }
}
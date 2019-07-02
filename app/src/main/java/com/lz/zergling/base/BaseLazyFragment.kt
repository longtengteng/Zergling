package com.lnkj.wzhr.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.inputMethodManager

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
abstract class BaseLazyFragment<P : BasePresent<*>> : Fragment() {
    protected val TAG = javaClass.simpleName
    protected lateinit var mContext: Context
    protected var rootView: View? = null
    abstract val mPresenter: P
    abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null)
            rootView = inflater.inflate(layoutRes, null)
        mContext = activity as Context
        isPrepared = true
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        initAll()
        setListener()
        processLogic()
        if (isPrepared && userVisibleHint) {
            loadData(isFirst)
            if (isFirst)
                isFirst = false
        }
    }

    protected abstract fun initAll()
    protected abstract fun setListener()
    protected abstract fun processLogic()

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    //是否可见
    protected var isVisble: Boolean = false
    // 标志位，标志Fragment已经初始化完成。
    protected var isPrepared = false
    // 标志位，标志是否第一次加载
    protected var isFirst = true

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            onVisible()
        } else {
            onInVisible()
        }
    }

    protected fun onInVisible() {}
    protected fun onVisible() {
        if (!isPrepared || !userVisibleHint) {
            return
        }
        loadData(isFirst)
        if (isFirst)
            isFirst = false
    }

    abstract fun loadData(boolean: Boolean)
}
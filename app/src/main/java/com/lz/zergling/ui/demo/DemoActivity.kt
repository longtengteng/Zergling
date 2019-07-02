package com.lz.zergling.ui.demo

import android.content.Context
import com.lnkj.wzhr.base.BaseActivity
import com.lz.zergling.R
import com.lz.zergling.util.utilcode.ToastUtils

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
class DemoActivity : BaseActivity<DemoContract.Present>(), DemoContract.View {

    override val mPresenter: DemoContract.Present
        get() = DemoPresent().also { it.attachView(this) }
    override val layoutRes: Int
        get() = R.layout.activity_demo

    override fun initLogic() {
        mPresenter?.indexGoods1(1)
    }

    override fun setListener() {

    }

    override fun processLogic() {

    }

    override fun getContext(): Context {
        return mContext
    }

    override fun onEmpty() {

    }

    override fun onError() {

    }

    override fun indexGoods1(mutableList: MutableList<IndexGoodsBean>) {
        ToastUtils.showShort("返回正确")
    }
}
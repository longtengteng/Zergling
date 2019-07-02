package com.lz.zergling.ui.demo


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lnkj.wzhr.base.BaseLazyFragment

import com.lz.zergling.R
import com.lz.zergling.util.utilcode.ToastUtils


/**
 * A simple [Fragment] subclass.
 */
class DemoFragment : BaseLazyFragment<DemoContract.Present>(), DemoContract.View {

    override val mPresenter: DemoContract.Present
        get() = DemoPresent().also { it.attachView(this) }
    override val layoutRes: Int
        get() = R.layout.fragment_demo

    companion object {
        fun newInstance(args: Bundle?): DemoFragment {
            val fragment = DemoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initAll() {

    }

    override fun setListener() {

    }

    override fun processLogic() {

    }

    override fun loadData(boolean: Boolean) {
        if (boolean)
            mPresenter?.indexGoods1(1)
    }

    override fun getContext(): Context {
        return mContext
    }

    override fun onEmpty() {

    }

    override fun onError() {

    }

    override fun indexGoods1(mutableList: MutableList<IndexGoodsBean>) {
        ToastUtils.showShort("xxxx")
    }
}

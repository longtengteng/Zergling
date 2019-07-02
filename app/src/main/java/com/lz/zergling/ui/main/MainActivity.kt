package com.lz.zergling.ui.main

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.lnkj.wzhr.base.BaseActivity
import com.lnkj.yongjinlianmeng.widget.CustomFragmentPagerAdapter
import com.lz.zergling.R
import com.lz.zergling.ui.demo.DemoActivity
import com.lz.zergling.ui.demo.DemoActivity2
import com.lz.zergling.ui.demo.DemoFragment
import com.lz.zergling.widget.NativeTabButton
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity<MainContract.Present>(), MainContract.View {

    override val mPresenter: MainContract.Present
        get() = MainPresent().also { it.attachView(this) }
    override val layoutRes: Int
        get() = R.layout.activity_main
    private var mTabButtons: Array<NativeTabButton>? = null
    private var mFragments: Array<Fragment>? = null
    private var title = intArrayOf(R.string.main_tab0, R.string.main_tab1, R.string.main_tab2, R.string.main_tab3, R.string.main_tab4)
    private var checkImage = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
    private var unCheckImage = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
    private var adapter: CustomFragmentPagerAdapter? = null

    override fun initLogic() {
        initTab()
        initFragment()
        setFragmentShow(0)
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

    fun initTab() {
        mTabButtons = arrayOf(tab0, tab1, tab2, tab3, tab4)
        for (i in mTabButtons!!.indices) {
            mTabButtons!![i].setTitle(getString(title[i]))
            mTabButtons!![i].setIndex(i)
            mTabButtons!![i].setSelectedImage(resources.getDrawable(checkImage[i]))
            mTabButtons!![i].setUnselectedImage(resources.getDrawable(unCheckImage[i]))
        }
    }

    fun initFragment() {
        mFragments = arrayOf(DemoFragment.newInstance(null), DemoFragment.newInstance(null), DemoFragment.newInstance(null), DemoFragment.newInstance(null), DemoFragment.newInstance(null))
        adapter = CustomFragmentPagerAdapter(mFragments, supportFragmentManager)
        sp_main.adapter = adapter
//        sp_main.offscreenPageLimit = 4
        sp_main.setScroll(true)
        sp_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                for (item in mTabButtons!!) {
                    item.setSelectedButton(false)
                }
                mTabButtons!![position].setSelectedButton(true)
            }
        })
    }

    fun setFragmentShow(index: Int) {
        sp_main.setCurrentItem(index, false)
        for (item in mTabButtons!!) {
            item.setSelectedButton(false)
        }
        mTabButtons!![index].setSelectedButton(true)
    }
}

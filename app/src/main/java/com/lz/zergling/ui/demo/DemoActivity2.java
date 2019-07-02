package com.lz.zergling.ui.demo;

import android.content.Context;

import com.lnkj.wzhr.base.BaseActivity;
import com.lz.zergling.R;
import com.lz.zergling.util.utilcode.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author 与天同行的观测者
 * @Copyright Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date $date$ $time$
 */

public class DemoActivity2 extends BaseActivity<DemoContract.Present> implements DemoContract.View {
    DemoContract.Present mPresent = null;

    @NotNull
    @Override
    public DemoContract.Present getMPresenter() {
        mPresent = new DemoPresent();
        mPresent.attachView(this);
        return mPresent;
    }

    @Override
    public int getLayoutRes() {
        getMPresenter();
        return R.layout.activity_demo;
    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {
        mPresent.indexGoods1(1);
    }

    @NotNull
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void indexGoods1(@NotNull List<IndexGoodsBean> mutableList) {
        ToastUtils.showShort("返回正确");
    }
}

package com.lz.zergling.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lz.zergling.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author 与天同行的观测者
 * @Copyright Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date $date$ $time$
 */

public class SmartRecycleView<M> extends RelativeLayout {
    public SmartRefreshLayout srl;
    public RecyclerView rv;
    public BaseQuickAdapter<M, BaseViewHolder> adapter;
    public int p = 1;

    public SmartRecycleView(Context context) {
        super(context);
        init(context);
    }

    public SmartRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SmartRecycleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_smart_recycleview, this);
        srl = findViewById(R.id.srl);
        rv = findViewById(R.id.rv);
    }

    public void initAdapter(BaseQuickAdapter adapter, RecyclerView.LayoutManager layoutManager) {
        rv.setLayoutManager(layoutManager);
        this.adapter = adapter;
        adapter.bindToRecyclerView(rv);
    }

    public int setData(int p, ArrayList<M> data) {
        if (p == 1) {
            if (adapter != null)
                adapter.setNewData(data);
            if (data == null || data.size() == 0) {
                if (adapter != null)
                    adapter.setEmptyView(R.layout.layout_empty);
            }
        } else {
            if (data == null || data.size() == 0) {
                p = p - 1;
            } else {
                if (adapter != null)
                    adapter.addData(data);
            }
        }
        return p;
    }
}

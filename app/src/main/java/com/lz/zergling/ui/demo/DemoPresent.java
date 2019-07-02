package com.lz.zergling.ui.demo;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.lnkj.wzhr.net.Net;
import com.lnkj.wzhr.net.UrlUtils;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author 与天同行的观测者
 * @Copyright Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date $date$ $time$
 */

public class DemoPresent extends DemoContract.Present {

    @Override
    public void indexGoods1(int type) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        Net.INSTANCE.post(getMContext(), new UrlUtils().getIndexGoods(), map, new Net.Callback() {
            @Override
            public void onSuccess(@Nullable Object t) {
                if (getMView() != null)
                    getMView().indexGoods1(JSON.parseArray(JSON.toJSONString(t), IndexGoodsBean.class));
            }

            @Override
            public void onError(@Nullable Throwable apiException) {

            }
        });
    }
}

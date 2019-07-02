package com.lz.zergling.ui.demo

import com.lnkj.wzhr.base.BasePresent
import com.lnkj.wzhr.base.BaseView

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
class DemoContract {
    interface View : BaseView {
        fun indexGoods1(mutableList: MutableList<IndexGoodsBean>)
    }

    abstract class Present : BasePresent<View>() {
        abstract fun indexGoods1(type: Int)
    }
}
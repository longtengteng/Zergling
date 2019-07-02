package com.lz.zergling.ui.main

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
class MainContract {
    interface View : BaseView {}
    abstract class Present : BasePresent<View>() {

    }
}
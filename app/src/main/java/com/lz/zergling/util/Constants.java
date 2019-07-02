package com.lz.zergling.util;


import android.os.Environment;

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author 与天同行的观测者
 * @Copyright Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date 2017/12/11 0011 14:19
 */

public class Constants {
    public static final String WX_APP_ID = "wx30843d59f81cda6a";
    public static final String QQ_APP_ID = "101519917";
    public static final int REQUEST_REFRESH = 2018;
    public static final int RESULT_REFRESH = 2019;
    public static final long CODE_TIME = 120000;
    public static final int BUFFER_TIME = 30;
    public static final int COUNT_SIZE = 10;
    public static final String IMAGE_PATH = Environment.getExternalStorageDirectory().toString() + "/LNKJ/images/";
    public static final int COMPRESS_INGNORE = 60;
    public static final String USERINFO = "userInfo";
    public static final int PAYSUCESS = 0x0001;
}

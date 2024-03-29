package com.lnkj.wzhr.net

import android.app.ProgressDialog
import android.content.Context
import android.view.Window
import com.liuniukeji.viscumcoloratum.http.exception.ApiException
import com.lz.zergling.MyApplication
import com.lz.zergling.R
import com.lz.zergling.base.BaseBean
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.HttpParams
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request
import org.json.JSONObject
import java.io.File

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author         与天同行的观测者
 * @Copyright      Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date           $date$ $time$
 */
object Net {
    fun post(activity: Context, url: String, map: Map<String, Any>, netCallback: Callback) {
        var params = HttpParams()
        for ((k, v) in map) {
            if (v is File) {
                params.put(k, v)
            } else {
                params.put(k, v.toString())
            }
        }
        OkGo.post<BaseBean<Any>>(url).tag(activity).params(params).execute(object : OkGoCallback<BaseBean<Any>>() {
            override fun onSuccess(response: Response<BaseBean<Any>>) {
                super.onSuccess(response)
                netCallback.onSuccess(response?.body()?.data)
                netCallback.onComplete()
            }

            override fun onStart(request: Request<BaseBean<Any>, out Request<*, *>>?) {
                super.onStart(request)
                netCallback.onStart()
            }

            override fun onFinish() {
                super.onFinish()
            }

            override fun onError(response: Response<BaseBean<Any>>) {
                super.onError(response)
                netCallback.onError(response.exception)
                if (response.exception is ApiException) {
                    when ((response.exception as ApiException).code) {
                        2 -> {
                            MyApplication.getInstance().reLogin()
                        }
                        else -> netCallback.onComplete()
                    }
                } else {
                    netCallback.onComplete()
                }
            }
        })
    }

    abstract class Callback(context: Context?, var isShow: Boolean = false, tag: String = context?.getString(R.string.connecting) ?: "") {
        constructor() : this(null, false, "")
        constructor(context: Context?, isShow: Boolean) : this(context, isShow, context?.getString(R.string.connecting) ?: "")

        lateinit var mDialog: ProgressDialog

        init {
            if (isShow) {
                mDialog = ProgressDialog(context)
                mDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
                mDialog?.setCanceledOnTouchOutside(false)
                mDialog?.setProgressStyle(ProgressDialog.STYLE_SPINNER)
                mDialog?.setMessage(tag)
            }
        }

        open fun onStart() {
            try {
                if (isShow && !mDialog?.isShowing)
                    mDialog?.show()
            } catch(e: Exception) {
            }
        }

        open fun onComplete() {
            try {
                if (isShow && mDialog?.isShowing)
                    mDialog?.dismiss()
            } catch(e: Exception) {
            }
        }

        abstract fun onSuccess(t: Any?)
        abstract fun onError(apiException: Throwable?)

    }
}
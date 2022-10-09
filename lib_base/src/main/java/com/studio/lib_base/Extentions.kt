package com.studio.lib_base

import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV

fun View.checkLogin(listener: LoginListener) {
    val token = MMKV.defaultMMKV().decodeString("token", "")
    this.setOnClickListener {
        if (token.isNullOrEmpty()) {
            ARouter.getInstance().build("/visitor/login").navigation()
        } else {
            listener.next()
        }
    }

}

fun ViewGroup.checkLogin(listener: LoginListener) {
    val token = MMKV.defaultMMKV().decodeString("token", "")
    this.setOnClickListener {
        if (token.isNullOrEmpty()) {
            ARouter.getInstance().build("/visitor/login").navigation()
        } else {
            listener.next()
        }
    }

}

interface LoginListener {
    fun next()
}

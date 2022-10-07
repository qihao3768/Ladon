package com.studio.ladon

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths
import com.tencent.mmkv.MMKV


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_splash)
        immersionBar {
            statusBarColor(R.color.white)
            statusBarDarkFont(true)
            fitsSystemWindows(true)
        }
    }


    override fun onResume() {
        super.onResume()

        var timer= object : CountDownTimer(2000,1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                if (mmkv.decodeString("token").isNullOrBlank()){
                    ARouter.getInstance().build(Paths.visitor_activity_main).navigation()
                }else{
                    ARouter.getInstance().build(Paths.app_activity_main).navigation()
                }
                finish()
            }
        }
        timer.start()
    }
}
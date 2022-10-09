package com.studio.ladon

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.studio.ladon.databinding.AppActivitySplashBinding
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths
import com.tencent.mmkv.MMKV


@SuppressLint("CustomSplashScreen")
class AppSplashActivity : BaseActivity() {

    private lateinit var binding: AppActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        immersionBar {
            statusBarColor(R.color.white)
            statusBarDarkFont(true)
            fitsSystemWindows(true)
        }
    }


    override fun onResume() {
        super.onResume()

        var timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
                binding.visitorSkip.text = "倒计时：${p0/1000}秒"
            }

            override fun onFinish() {
                skip()
            }
        }
        timer.start()

    }

    fun skip(){
        if (mmkv.decodeString("token").isNullOrBlank()) {
            ARouter.getInstance().build(Paths.visitor_activity_main).navigation()
        } else {
            ARouter.getInstance().build(Paths.app_activity_main).navigation()
        }
        finish()
    }
}
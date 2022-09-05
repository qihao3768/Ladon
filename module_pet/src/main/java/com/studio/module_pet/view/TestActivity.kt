package com.studio.module_pet.view

import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.studio.lib_base.BaseActivity
import com.studio.module_pet.R

@Route(path = "/test/activity")
class TestActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        findViewById<TextView>(R.id.text).setOnClickListener {
            ARouter.getInstance().build("/test/main").navigation()
        }

    }
}
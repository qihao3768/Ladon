package com.studio.ladon

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths
import com.studio.module_pet.view.MainActivity

@Route(path = Paths.app_activity_main)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).setOnClickListener {
            ARouter.getInstance().build("/test/activity").navigation()
        }



    }

}
package com.studio.ladon

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths

@Route(path = Paths.app_activity_main)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)


    }

}
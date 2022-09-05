package com.studio.module_pet.view

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.studio.lib_base.BaseActivity
import com.studio.module_pet.R

@Route(path = "/test/main")
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
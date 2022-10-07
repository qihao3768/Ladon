package com.studio.module_visitor.view

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths
import com.studio.module_visitor.R
import com.studio.module_visitor.databinding.VisitorActivityMainBinding


@Route(path = Paths.visitor_activity_main)
class VisitorMainActivity : BaseActivity() {
    private lateinit var binding: VisitorActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = VisitorActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        immersionBar {
            statusBarColor(R.color.white)
            statusBarDarkFont(true)
        }

        binding.visitorTextView2.setOnClickListener {
            ARouter.getInstance().build(Paths.visitor_activity_login).navigation()
        }

    }
}
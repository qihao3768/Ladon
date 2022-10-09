package com.studio.module_visitor.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.studio.lib_base.BaseActivity
import com.studio.lib_base.LoginListener
import com.studio.lib_base.checkLogin
import com.studio.lib_common.arouter.Paths
import com.studio.module_visitor.databinding.VisitorActivityMainBinding


@Route(path = Paths.visitor_activity_main)
class VisitorMainActivity : BaseActivity() {
    private lateinit var binding: VisitorActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = VisitorActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        immersionBar {
            fitsSystemWindows(true)
            statusBarColor(com.studio.lib_common.R.color.common_FE9520)
        }

        binding.visitorSearchEdit.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.visitorSearchView.checkLogin(object :LoginListener{
            override fun next() {
                ARouter.getInstance().build(Paths.app_activity_main).navigation()
            }

        })
    }
}
package com.studio.ladon

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.studio.ladon.databinding.AppActivityMainBinding
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths

@Route(path = Paths.app_activity_main)
class AppMainActivity : BaseActivity() {
    private lateinit var binding: AppActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}
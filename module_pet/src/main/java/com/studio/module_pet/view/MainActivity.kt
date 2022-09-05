package com.studio.module_pet.view

import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.RequestCallback
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.permission.PermissionGroup
import com.studio.module_pet.R

@Route(path = "/test/main")
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionX.init(this).permissions(PermissionGroup.camera).request(object :RequestCallback{
            override fun onResult(
                allGranted: Boolean,
                grantedList: MutableList<String>,
                deniedList: MutableList<String>
            ) {
              Toast.makeText(this@MainActivity,"2222",Toast.LENGTH_SHORT).show()
            }

        })
    }
}
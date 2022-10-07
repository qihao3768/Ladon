package com.studio.module_visitor.view

import android.os.Bundle
import android.text.Editable
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths
import com.studio.module_visitor.databinding.VisitorActivityLoginBinding
import com.studio.module_visitor.repository.UserInfoRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Route(path = Paths.visitor_activity_login)
class VisitorLoginActivity : BaseActivity() {
    private var sms: Editable? = null
    private var keyCode: String? = null
    private lateinit var binding: VisitorActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VisitorActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        binding.visitorImageview.setOnClickListener {
            GlobalScope.launch {
                var rawData = UserInfoRepository.sendVer("18332091137")
                 keyCode = rawData.data?.key_code
                 sms = binding.visitorEdittext.text

            }

        }

        binding.visitorImageview2.setOnClickListener {
            GlobalScope.launch {
                var rawData = UserInfoRepository.smsLogin(
                    "18332091137", sms.toString(),
                    keyCode.toString()
                )
                Log.d("TAG", "response: ${rawData.data?.access_token}")
                mmkv.encode("token",rawData.data?.access_token)
            }

        }


    }
}
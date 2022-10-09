package com.studio.module_visitor.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.studio.lib_base.BaseActivity
import com.studio.lib_common.arouter.Paths
import com.studio.module_visitor.databinding.VisitorActivityLoginBinding
import com.studio.module_visitor.repository.UserInfoRepository
import com.studio.module_visitor.viewmodel.UserViewModel
import kotlinx.coroutines.*

@Route(path = Paths.visitor_activity_login)
class VisitorLoginActivity : BaseActivity() {
    private var sms: String? = ""
    private var keyCode: String? = ""
    private var phone: String? = ""
    private lateinit var binding: VisitorActivityLoginBinding
    val userViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VisitorActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        immersionBar {
            fitsSystemWindows(true)
            statusBarDarkFont(true)
        }
    }

    override fun onResume() {
        super.onResume()

        binding.visitorSkipMain.setOnClickListener {
            ARouter.getInstance().build(Paths.visitor_activity_main).navigation()
            finish()
        }

        binding.visitorLoginPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                binding.visitorLoginClear.visibility = View.VISIBLE
                phone = p0.toString()
            }

        })
        binding.visitorLoginSendSms.setOnClickListener {
            userViewModel.sendVer(phone.toString())
        }

        binding.visitorLogin.setOnClickListener {
            keyCode = userViewModel.rawData.data?.key_code
            sms = binding.visitorLoginSms.text.toString()

            Log.e("TAG", "onResume: ${keyCode}" )
       /*     CoroutineScope(job).launch(Dispatchers.Main) {
                var rawData = UserInfoRepository.smsLogin(
                    phone.toString(), sms.toString(),
                    keyCode.toString()
                )
                Log.d("TAG", "token: ${rawData.data?.access_token}")
                mmkv.encode("token", rawData.data?.access_token)
            }
*/
        }

    }
}
package com.studio.module_visitor.viewmodel

import com.studio.lib_base.BaseViewModel
import com.studio.lib_base.network.BaseResponseData
import com.studio.module_visitor.model.UserInfo
import com.studio.module_visitor.repository.UserInfoRepository

//AndroidViewModel 可传入context 不可直接传入activity
class UserViewModel : BaseViewModel() {
    var rawData = BaseResponseData<UserInfo>()
    fun sendVer(phone: String): BaseResponseData<UserInfo> {
        launchUI {
               rawData = UserInfoRepository.sendVer(phone)
        }
        return rawData
    }
}
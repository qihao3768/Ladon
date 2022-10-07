package com.studio.module_visitor.repository

import com.studio.lib_base.network.BaseRepository
import com.studio.lib_base.network.BaseResponseData
import com.studio.lib_base.network.RetrofitBuilder
import com.studio.module_visitor.model.PhoneInfo
import com.studio.module_visitor.model.UserInfo
import com.studio.module_visitor.service.UserService

object UserInfoRepository :BaseRepository(){
    val userService=RetrofitBuilder.create(UserService::class.java)

   suspend fun sendVer(phone:String):BaseResponseData<UserInfo> =request{
        userService.sendVer(phone)
    }

    suspend fun smsLogin(phone:String,sms:String,key_code:String):BaseResponseData<PhoneInfo> =request{
        userService.smsLogin(phone,sms,key_code)
    }

}
package com.studio.module_visitor.service

import com.studio.lib_base.network.BaseResponseData
import com.studio.module_visitor.model.PhoneInfo
import com.studio.module_visitor.model.UserInfo
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    @FormUrlEncoded
    @POST("api/sms/sendVer")
    suspend fun sendVer(@Field("phone") phone: String): BaseResponseData<UserInfo>


    @FormUrlEncoded
    @POST("api/user/smsLogin")
    suspend fun smsLogin(
        @Field("phone") phone: String,
        @Field("sms") sms: String,
        @Field("key_code") key_code: String
    ): BaseResponseData<PhoneInfo>

}
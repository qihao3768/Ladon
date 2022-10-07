package com.studio.module_visitor.model

import com.google.gson.annotations.SerializedName
import com.studio.lib_base.network.BaseResponseData

/*{
    "code": 1000,
    "message": "success",
    "data": {
    "key_code": "3621",
    "expired_at": "2022-05-26 11:29:11"
},
    "status_code": 200
}*/
data class UserInfo(
    @SerializedName("key_code")
    val key_code:String="",
    @SerializedName("expired_at")
    val expired_at:String=""
)

data class PhoneInfo(
    @SerializedName("access_token")
    val access_token:String="",
    @SerializedName("token_type")
    val token_type:String="",
    @SerializedName("expires_in")
    val expires_in:String="",
    @SerializedName("phone")
    val phone:String="",
    @SerializedName("info_flag")
    val info_flag:String="",

)

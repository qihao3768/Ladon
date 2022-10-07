package com.studio.lib_base.network

import com.google.gson.annotations.SerializedName

class BaseResponseData<T> {
    //  {"code":1001,"message":"请输入反馈内容","data":[],"status_code":500}
    @SerializedName("status_code")
    val status_code: Int = 0
    @SerializedName("code")
    val code: Int = 0
    @SerializedName("message")
    val message: String = ""
    @SerializedName("data")
    val data: T? = null
}
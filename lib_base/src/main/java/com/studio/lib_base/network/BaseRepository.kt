package com.studio.lib_base.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {

    suspend fun <T : Any> request(call: suspend () -> BaseResponseData<T>): BaseResponseData<T> {

        return withContext(Dispatchers.IO) {
           call.invoke()
        }.apply {
            Log.d("responseData:","接口返回数据---------->${this.data}")
        }
    }

}
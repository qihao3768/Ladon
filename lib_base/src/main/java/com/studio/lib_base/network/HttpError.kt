package com.studio.lib_base.network

import android.widget.Toast
import com.studio.lib_base.GlobalApplication
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import kotlin.coroutines.cancellation.CancellationException


object HttpError {

    fun deal(error: Throwable) {
        when (error) {
            is SocketException -> Toast.makeText(
                GlobalApplication.context,
                "服务器连接异常",
                Toast.LENGTH_SHORT
            ).show()

            is SocketTimeoutException -> {
                Toast.makeText(GlobalApplication.context, "服务器连接超时", Toast.LENGTH_SHORT).show()
            }
            is IOException -> {
                Toast.makeText(GlobalApplication.context, "数据流读写异常", Toast.LENGTH_SHORT).show()
            }
            is CancellationException -> {
                //协程被取消 这里是正常的 不提示
                Toast.makeText(GlobalApplication.context, "协程已取消", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(GlobalApplication.context, "未知异常", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
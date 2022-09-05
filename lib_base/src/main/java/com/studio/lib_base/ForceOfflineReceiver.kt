package com.studio.lib_base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context?.let {
            AlertDialog.Builder(it).apply {
                setTitle("您已被强制下线!~")
                setMessage("由于您违反了用户相关守则，已被系统强制下线处理，请联系客服人员~")
                setCancelable(false)
                setPositiveButton("知道啦") { _, _ ->
                    ActivityCollector.finishAll()
                }
                show()
            }
        }
    }
}
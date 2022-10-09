package com.studio.lib_base


import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.Job

open class BaseActivity : AppCompatActivity() {
    val mmkv: MMKV = MMKV.defaultMMKV()
    val job= Job()
    lateinit var offlineReceiver: ForceOfflineReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //知晓当前所在activity
        Log.d("CurrentActivity", javaClass.simpleName)
        actionBar?.hide()
        //加入activity收集器
        ActivityCollector.addActivity(this)
    }

    fun toast(message: String) {
        Toast.makeText(GlobalApplication.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter("com.studio.lib_base.FORCE_OFFLINE")
        offlineReceiver = ForceOfflineReceiver()
        registerReceiver(offlineReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(offlineReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        //从activity收集器移除
        ActivityCollector.removeActivity(this)
    }
}
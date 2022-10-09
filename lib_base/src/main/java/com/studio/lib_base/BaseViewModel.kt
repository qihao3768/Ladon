package com.studio.lib_base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studio.lib_base.network.HttpError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull


open class BaseViewModel : ViewModel() {
    //运行在UI线程的协程
    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        try {
            withTimeoutOrNull(15 * 1000) {
                block()
            }
        } catch (e: Exception) {
            HttpError.deal(e)
        }
    }
}
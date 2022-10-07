package com.studio.lib_base

import android.widget.Toast

fun toast(message:String) {
    Toast.makeText(GlobalApplication.context,message, Toast.LENGTH_SHORT).show()
}
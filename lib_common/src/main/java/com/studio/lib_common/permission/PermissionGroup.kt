package com.studio.lib_common.permission

import android.Manifest

object PermissionGroup {
    val camera: ArrayList<String> = arrayListOf<String>(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
}
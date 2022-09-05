package com.studio.lib_base

import android.app.Activity

object ActivityCollector {
    private val activitys = ArrayList<Activity>()

    @JvmStatic
    fun addActivity(activity: Activity) {
        activitys.add(activity)
    }

    @JvmStatic
    fun removeActivity(activity: Activity) {
        activitys.remove(activity)
    }

    @JvmStatic
    fun finishAll() {
        for (activity in activitys) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activitys.clear()
    }
}
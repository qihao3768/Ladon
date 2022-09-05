package com.studio.ladon

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.studio.lib_base.BaseActivity
import com.studio.module_pet.view.TestActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).setOnClickListener {
             val intent:Intent= Intent(this,TestActivity::class.java)
            //intent.setAction("com.studio.lib_base.FORCE_OFFLINE")
           // sendBroadcast(intent)
            startActivity(intent)
        }



    }

}
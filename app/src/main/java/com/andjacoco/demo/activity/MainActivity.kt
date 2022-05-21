package com.andjacoco.demo.activity

import android.content.Intent
import android.os.Bundle
import com.andjacoco.demo.action.BaseAction
import com.andjacoco.demo.R
import com.andjacoco.demo.action.SecondAction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BaseAction.Toast(this, "hello132")
        SecondAction.sayHello()

        tv.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        BaseAction.hello(false)

    }


}
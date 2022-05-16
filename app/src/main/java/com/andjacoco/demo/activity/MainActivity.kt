package com.andjacoco.demo.activity

import android.content.Intent
import android.os.Bundle
import com.andjacoco.demo.action.Hello
import com.andjacoco.demo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Hello.Toast(this, "hello132")

        tv.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        Hello.hello(false)

    }


}
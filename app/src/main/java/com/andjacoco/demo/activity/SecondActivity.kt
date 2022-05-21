package com.andjacoco.demo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.andjacoco.demo.action.FourthAction
import com.andjacoco.demo.R
import com.andjacoco.demo.action.SecondAction
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        secondTest()

        findViewById<TextView>(R.id.tv_second).setOnClickListener({
            startActivity(Intent(this, TestActivity::class.java))
        })
        SecondAction.sayHello()
//        ThirdHello().sayHello()
        FourthAction.sayHello()

        addTest()


    }


    private fun addTest() {
        val i = 30
        val j = 3
        val z = i / j
        Log.i("jacoco-log", z.toString())
    }


    fun secondTest() {
        Log.i("tag", "asdasd")
    }
}
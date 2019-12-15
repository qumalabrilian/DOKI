package com.example.bear.dongengin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun listCerita(view: View) {
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        startActivity(intent)
        setIndex(1)
    }

    fun listCerita2(view: View) {
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        startActivity(intent)
        setIndex(2)
    }

    fun setIndex(i: Int): Int {
        index = i
        return index
    }

    fun listCerita3(view: View) {
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        startActivity(intent)
        setIndex(3)
    }

    companion object {

        var index: Int = 0
    }
}

package com.example.bear.dongengin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

import java.util.ArrayList

class Main2Activity : AppCompatActivity() {

    internal lateinit var listView: ListView
    internal val lst = ArrayList<String>()
    internal lateinit var y: String
    internal var p = MainActivity.index

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listView = findViewById<View>(R.id.list) as ListView

        setList(p)
        val adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lst)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> setcont(position) }
    }

    fun setjudul(jdl: String): String {
        judul = jdl
        return judul
    }

    fun setkode(code: Int): Int {
        kode = code
        return kode
    }

    fun setcont(code: Int) {
        setkode(code)
        y = lst[code]
        setjudul(y)
        val intent = Intent(this@Main2Activity, Main22Activity::class.java)
        startActivity(intent)
    }

    fun setList(`val`: Int) {
        if (`val` == 1) {
            lst.add("Si Kancil Mencuri Timun")
            lst.add("Si Kancil dan Kerbau")
            lst.add("Si Kancil dan Buaya")
            lst.add("Bawang Merah dan Bawang Putih")
            lst.add("Kerbau dan Monyet Licik")
            lst.add("Semut dan Belalang yang Malas")
            lst.add("Kelinci dan Kura-Kura")
            lst.add("Si Kancil dan Raja Monyet")
            setQ(1)
        } else if (`val` == 2) {
            lst.add("Gembala Pembohong dan Serigala")
            lst.add("Urashima Taro")
            lst.add("Hansel dan Grethel")
            lst.add("Pemerah Susu dan Embernya")
            setQ(2)
        } else {
            lst.add("Malin Kundang")
            lst.add("Lutung Kasarung")
            lst.add("Jaka Tarub")
            lst.add("Keong Mas")
            lst.add("Timun Mas")
            setQ(3)
        }
    }

    fun setQ(u: Int): Int {
        q = u
        return q
    }

    companion object {
        lateinit var judul: String
        var kode: Int = 0
        var q: Int = 0
    }
}
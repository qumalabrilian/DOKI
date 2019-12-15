package com.example.bear.dongengin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.mapzen.speakerbox.Speakerbox

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

class Main22Activity : AppCompatActivity() {

    internal var indexGen = Main2Activity.q
    internal var kd = Main2Activity.kode
    internal var ttl = Main2Activity.judul

    internal lateinit var speakerbox: Speakerbox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main22)

        val tittle = findViewById<View>(R.id.title) as TextView
        tittle.text = ttl
        speakerbox = Speakerbox(application)
        val helloTxt = findViewById<View>(R.id.story) as TextView
        val sound = findViewById<ImageView>(R.id.iv_sound)
        val soundOff = findViewById<ImageView>(R.id.iv_soundoff)

        helloTxt.text = readTxt(kd)
        speakerbox.play(readTxt(kd))

        sound.setOnClickListener {
            speakerbox.play(helloTxt.text.toString().trim { it <= ' ' })
            sound.visibility = View.GONE
            soundOff.visibility = View.VISIBLE
        }

        soundOff.setOnClickListener {
            speakerbox.stop()
            soundOff.visibility = View.GONE
            sound.visibility = View.VISIBLE
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        speakerbox.stop()
    }

    private fun readTxt(kode: Int): String {
        val inputStream: InputStream
        if (indexGen == 1) {
            if (kode == 0) {
                inputStream = resources.openRawResource(R.raw.kanciltimun)
            } else if (kode == 1) {
                inputStream = resources.openRawResource(R.raw.kancil2)
            } else if (kode == 2) {
                inputStream = resources.openRawResource(R.raw.kancil3)
            } else if (kode == 4) {
                inputStream = resources.openRawResource(R.raw.bawangpr)
            } else if (kode == 5) {
                inputStream = resources.openRawResource(R.raw.monkerbau)
            } else if (kode == 6) {
                inputStream = resources.openRawResource(R.raw.sembelalang)
            } else if (kode == 7) {
                inputStream = resources.openRawResource(R.raw.kelkur)
            } else {
                inputStream = resources.openRawResource(R.raw.kancmon)
            }
        } else if (indexGen == 2) {
            if (kode == 0) {
                inputStream = resources.openRawResource(R.raw.gembalaserigala)
            } else if (kode == 1) {
                inputStream = resources.openRawResource(R.raw.urashimataro)
            } else if (kode == 2) {
                inputStream = resources.openRawResource(R.raw.hansel)
            } else {
                inputStream = resources.openRawResource(R.raw.daydreamer)
            }
        } else {
            if (kode == 0) {
                inputStream = resources.openRawResource(R.raw.malinkundang)
            } else if (kode == 1) {
                inputStream = resources.openRawResource(R.raw.lutungkasarung)
            } else if (kode == 2) {
                inputStream = resources.openRawResource(R.raw.jakatarub)
            } else if (kode == 3) {
                inputStream = resources.openRawResource(R.raw.keongmas)
            } else {
                inputStream = resources.openRawResource(R.raw.timunmas)
            }
        }

        println(inputStream)
        val byteArrayOutputStream = ByteArrayOutputStream()

        var i: Int
        try {
            i = inputStream.read()
            while (i != -1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {

            e.printStackTrace()
        }

        return byteArrayOutputStream.toString()
    }
}

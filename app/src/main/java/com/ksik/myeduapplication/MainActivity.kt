package com.ksik.myeduapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val aa : (Int) -> Double = {it.toDouble()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aa(1)
        setContentView(R.layout.activity_main)
    }
}
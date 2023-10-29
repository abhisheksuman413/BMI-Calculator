package com.fps69.bmicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class Spwithoutloding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spwithoutloding)


        Handler(Looper.getMainLooper()).postDelayed(5000){ // Activity delay krne ka syntax hai bsss
            startActivity(Intent(this,MainActivity::class.java))
            finish() // Iss se ye activity end ho jyega back krne pe nhi aayega
        }
    }
}
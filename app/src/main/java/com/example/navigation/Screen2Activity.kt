package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.ActivityScreen2Binding

class Screen2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("NAVEXAMPLE", "Screen2 -> onCreate")

        binding.screen2Title.text = "Screen 2 [$this]"

        binding.screen2ButtonToScreen3.setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen2 -> Click on 'To screen 3'")
            openScreen3()
        }
    }

    private fun openScreen3() {
        val intent = Intent(this, Screen3Activity::class.java)

        this.startActivity(intent)
    }
}

package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.navigation.databinding.ActivityScreen1Binding

class Screen1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityScreen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("NAVEXAMPLE", "Screen1 -> onCreate")

        binding.screen1Title.text = "Screen 1 [$this]"

        binding.screen1ButtonToScreen2.setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen1 -> Click on 'To screen 2'")
            openScreen2()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("NAVEXAMPLE", "Screen 1 -> onNewIntent")
    }

    private fun openScreen2() {
        val intent = Intent(this, Screen2Activity::class.java)

        this.startActivity(intent)
    }
}
package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.ActivityScreen3Binding

class Screen3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityScreen3Binding
    private val handler = android.os.Handler(Looper.getMainLooper())

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Toast.makeText(this@Screen3Activity, "Нажмите ещё раз, чтобы перейти на предыдущий экран", Toast.LENGTH_SHORT).show()
            isEnabled = false
            handler.postDelayed({isEnabled = true}, 2000L)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this,callback)

        Log.d("NAVEXAMPLE", "Screen3 -> onCreate")

        binding.screen3Title.text = "Screen 3 [$this]"

        binding.screen3ButtonToScreen1.setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'To screen 1'")
            openScreen1()
        }

        binding.screen3ButtonBack.setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back")
            back()
        }

        binding.screen3ButtonToScreen3.setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'To screen 3'")
            openScreen3()
        }

        binding.screen3ButtonToScreen1WithClear.setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back to Screen 1'")
            backToScreen1()
        }
    }

    private fun openScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)

        this.startActivity(intent)
    }

    private fun back() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d("NAVEXAMPLE", "Screen3 -> onNewIntent")
    }

    private fun openScreen3() {
        val intent = Intent(this, Screen3Activity::class.java)

        this.startActivity(intent)
    }

    private fun backToScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)

        this.startActivity(intent)
    }
}
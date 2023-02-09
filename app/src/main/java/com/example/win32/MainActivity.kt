package com.example.win32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win32.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LoadImage.load(binding.linearLayoutMain, this)
        binding.startGameButton.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
    }
}
package com.example.lv3_zadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv3_zadatak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
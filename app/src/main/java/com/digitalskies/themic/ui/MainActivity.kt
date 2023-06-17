package com.digitalskies.themic.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalskies.themic.R
import com.digitalskies.themic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
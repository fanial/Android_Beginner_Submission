package com.codefal.android_beginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codefal.android_beginner.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private var _binding : ActivityProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
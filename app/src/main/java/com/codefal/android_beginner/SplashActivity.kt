package com.codefal.android_beginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.codefal.android_beginner.databinding.ActivitySplashBinding

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private var _binding : ActivitySplashBinding? = null
    private val binding get() = _binding!!
    private val TIME = 3000 //3 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //hide actionbar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        //handler for time splash
        Handler().postDelayed({
            // Start main activity
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            // Close this activity
            finish()
        }, TIME.toLong())
    }
}
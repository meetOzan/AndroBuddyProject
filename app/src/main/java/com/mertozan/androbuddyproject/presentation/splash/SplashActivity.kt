package com.mertozan.androbuddyproject.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mertozan.androbuddyproject.MainActivity
import com.mertozan.androbuddyproject.R
import com.mertozan.androbuddyproject.common.ANIMATION_TIME

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(this.mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, ANIMATION_TIME)
    }
}


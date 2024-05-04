package com.mertozan.androbuddyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mertozan.androbuddyproject.presentation.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private val transaction = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transaction.add(R.id.fragment_container_view, HomeFragment())
        transaction.commit()

    }

}
package com.gutib.permissionexplorer.activity5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gutib.permissionexplorer.activity5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.nextPage.setOnClickListener{
            val intent = Intent(this, SecondPage::class.java)
            startActivity(intent)
        }


    }
}
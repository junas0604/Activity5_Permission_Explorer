package com.gutib.permissionexplorer.activity5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gutib.permissionexplorer.activity5.databinding.ActivitySecondPageBinding


private const val STORAGE_PERMISSION_CODE = 1
private const val LOCATION_PERMISSION_CODE = 2
private const val CAMERA_PERMISSION_CODE = 3

class SecondPage : AppCompatActivity() {
    private lateinit var binding : ActivitySecondPageBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {
            requestPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
        }

        binding.btnLocation.setOnClickListener {
            requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_CODE)
        }

        binding.btnAudio.setOnClickListener {
            requestPermission(Manifest.permission.RECORD_AUDIO, STORAGE_PERMISSION_CODE)
        }

        binding.back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun requestPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "$permission is granted", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "permission is granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
        }
    }

}
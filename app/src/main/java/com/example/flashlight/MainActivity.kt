package com.example.flashlight

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button:ImageView=findViewById(R.id.btn)
        var light:ImageView=findViewById(R.id.yellowLight)
        var cm:CameraManager=getSystemService(Context.CAMERA_SERVICE) as CameraManager
        var boolFlag=false

        button.setImageResource(R.drawable.ic_button_red)
        button.isClickable=true
        light.visibility=View.GONE

        button.setOnClickListener() {
            if(!boolFlag){
                var cameraListId=cm.cameraIdList[0]
                cm.setTorchMode(cameraListId, true)
                button.setImageResource(R.drawable.ic_button_green)
                light.visibility=View.VISIBLE
                boolFlag=true
                return@setOnClickListener
            } else{
                var cameraListId=cm.cameraIdList[0]
                cm.setTorchMode(cameraListId, false)
                button.setImageResource(R.drawable.ic_button_red)
                light.visibility=View.GONE
                boolFlag=false
                return@setOnClickListener
            }
        }
    }
}
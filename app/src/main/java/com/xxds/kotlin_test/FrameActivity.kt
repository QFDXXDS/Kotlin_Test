package com.xxds.kotlin_test

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        picBt.setOnClickListener {


            requestPermission()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0x123 && grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            val intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent,0x111)

        }
    }

    fun requestPermission() {

        requestPermissions(FrameActivity.permissons,0x123)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)



    }


    companion object {

        val permissons = arrayOf(
//            android.Manifest.permission.READ_CONTACTS
            android.Manifest.permission.CAMERA
        )
    }

}

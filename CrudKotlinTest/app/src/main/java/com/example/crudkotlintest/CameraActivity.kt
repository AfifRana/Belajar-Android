package com.example.crudkotlintest

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        btnCamera.setOnClickListener{
            dispatchTakePictureIntent()
        }

        btnGallery.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else{
                    //permission already granted
                    dispatchTakePictureIntent2()
                }
            }
            else{
                //system OS is < Marshmallow
                dispatchTakePictureIntent2()
            }
        }

        btnToMain.setOnClickListener {
//            val intent = Intent(this, MainActivity)
//            startActivity(MainActivity)
        }
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    dispatchTakePictureIntent2()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_IMAGE_CAPTURE_2 = 2

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    private fun dispatchTakePictureIntent2() {
        val takePictureIntent = Intent(Intent.ACTION_PICK).setType("image/*")
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_2)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("RESULT","Masuk")
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            photo.setImageBitmap(imageBitmap)
        } else if (requestCode == REQUEST_IMAGE_CAPTURE_2 && resultCode == RESULT_OK) {
//            val imageBitmap = data?.extras?.get("data")
            photo2.setImageURI(data?.data)
        }
    }
}
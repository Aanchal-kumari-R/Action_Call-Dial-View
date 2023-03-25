package com.example.implicitintentactivity

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.implicitintentactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActionView.setOnClickListener(this)
        binding.btnActionDial.setOnClickListener(this)
        binding.btnActionCall.setOnClickListener(this)
    }

    override fun onClick( view: View?) {
        when(view!!.id) {


            R.id.btn_action_view -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/reference/android/content/Intent"))
                 startActivity(intent)
                 }
            R.id.btn_action_dial -> {
                val intent= Intent(Intent.ACTION_DIAL, Uri.parse("tel:456434344"))
                startActivity(intent)
            }

             R.id.btn_action_call -> {

                 if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED) {
                     val intent = Intent(Intent.ACTION_CALL)
                     intent.data = Uri.parse("tel:786897788")
                     startActivity(intent)

                 }
                 else {
                     ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CALL_PHONE),1001)
                    // ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1001
                 }

                 }
             }
            }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==1001 ) {
         if (grantResults.isNotEmpty() && permissions[0].equals(PackageManager.PERMISSION_GRANTED) ) {
         } else {
         Toast.makeText(this,"Please give permission",Toast.LENGTH_LONG).show()
         }
        }
    }

        }


package com.wannachat.roboticsza.example.call_phone

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wannachat.roboticsza.example.R
import kotlinx.android.synthetic.main.activity_callphone.*
import rebus.permissionutils.PermissionEnum
import rebus.permissionutils.PermissionManager
import rebus.permissionutils.PermissionUtils

class CallPhoneActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_callphone)

        setupButton()

    }

    private fun setupButton(){
        btnCallPhone.setOnClickListener {
            val phone = getNumberPhone()
            if(phone.isEmpty()){
                // phone is empty
                return@setOnClickListener
            }
            if(!validNumberPhone(phone)){
                // phone is invalid
                return@setOnClickListener
            }

            requestPermissionPhone(phone)
        }
    }

    private fun requestPermissionPhone(phone:String){
        if(!PermissionUtils.isGranted(this, PermissionEnum.WRITE_EXTERNAL_STORAGE)) {
            PermissionManager.Builder()
                    .permission(PermissionEnum.CALL_PHONE)
                    .askAgain(true)
                    .callback({ isSuccess ->
                        if (isSuccess) {
                            // intent here
                            callPhone(phone)
                        }
                    })
                    .ask(this)
        }else{
            callPhone(phone)
        }

    }

    @SuppressLint("MissingPermission")
    private fun callPhone(phone:String){
        val callIntent = Intent(Intent.ACTION_CALL)
        val phoneStr = "tel:$phone"
        callIntent.data = Uri.parse(phoneStr)
        startActivity(callIntent)
    }

    private fun getNumberPhone():String{
        return editPhone.text.toString()
    }

    private fun validNumberPhone(rawPhone:String):Boolean{
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handleResult(this,requestCode,permissions,grantResults)
    }
}
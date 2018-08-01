package com.wannachat.roboticsza.example.qrGen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wannachat.roboticsza.example.R
import kotlinx.android.synthetic.main.activity_qrgen.*
import net.glxn.qrgen.android.QRCode

class QRGenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrgen)
        val mBitmap = QRCode.from("hello").withSize(500,500).bitmap()
        imageQR.setImageBitmap(mBitmap)
    }

}
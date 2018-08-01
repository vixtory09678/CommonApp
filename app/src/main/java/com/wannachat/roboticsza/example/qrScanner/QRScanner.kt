package com.wannachat.roboticsza.example.qrScanner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.wannachat.roboticsza.example.R
import rebus.permissionutils.PermissionEnum
import rebus.permissionutils.PermissionManager
import rebus.permissionutils.PermissionUtils

class QRScanner : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscan)

        requestPermissionCamera()
    }

    private fun requestPermissionCamera(){
        if(!PermissionUtils.isGranted(this, PermissionEnum.CAMERA)) {
            PermissionManager.Builder()
                    .permission(PermissionEnum.CAMERA)
                    .askAgain(true)
                    .callback({ isSuccess ->
                        if (isSuccess) {
                            // intent here
                            setupQRScan()
                        }
                    })
                    .ask(this)
        }else{
            setupQRScan()
        }

    }

    private fun setupQRScan(){
        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)
        codeScanner = CodeScanner(this, scannerView)

        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                Toast.makeText(this, "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(this, "Camera initialization error: ${it.message}",
                        Toast.LENGTH_LONG).show()
            }
        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handleResult(this,requestCode,permissions,grantResults)
    }
}
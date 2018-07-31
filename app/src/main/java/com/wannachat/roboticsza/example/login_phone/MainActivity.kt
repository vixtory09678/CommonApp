package com.wannachat.roboticsza.example.login_phone

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.wannachat.roboticsza.example.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private var mVerificationId:String = ""
    private var mResendToken:PhoneAuthProvider.ForceResendingToken? = null

    lateinit var dialog:ProgressDialog

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView(){
        mAuth.setLanguageCode("TH")
        login.setOnClickListener(this)
        dialog = indeterminateProgressDialog("Loading..")
        dialog.dismiss()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.login -> {
                verifyPhone()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance()
        if(user.currentUser != null){
            startActivity<PassLoginActivity>()
        }
    }

    private val mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(credential: PhoneAuthCredential?) {
            signInWithPhoneAuthCredential(credential)
            if(dialog.isShowing){
                dialog.dismiss()
            }
        }

        override fun onVerificationFailed(e: FirebaseException?) {
            when(e){
                is FirebaseAuthInvalidCredentialsException -> {
                    println("${e.cause} ${e.message}")
                }

                is FirebaseTooManyRequestsException -> {
                    println("${e.cause} ${e.message}")
                }

                else -> {
                    if (e != null) {
                        println("${e.cause} ${e.message}")
                    }
                }
            }
            if(dialog.isShowing){
                dialog.dismiss()
            }
        }

        override fun onCodeSent(verifyId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
            super.onCodeSent(verifyId, token)
            Log.d("Callback OnVerification", "OnCodeSent : $verifyId")
            mVerificationId = verifyId!!
            mResendToken = token

            if(dialog.isShowing){
                dialog.dismiss()
            }
        }
    }

    private fun verifyPhone(){

        if(!dialog.isShowing){
            dialog.show()
        }

        val phoneNum : String = phone.text.toString()

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNum,
                60,
                TimeUnit.SECONDS,
                this,
                mCallback
        )
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential?){
        mAuth.signInWithCredential(credential!!)
                .addOnCompleteListener{ it ->
                    if(it.isSuccessful){
                        val user= FirebaseAuth.getInstance()
                        if(user.currentUser != null){
                            startActivity<PassLoginActivity>()
                        }
                    }
                }
    }
}

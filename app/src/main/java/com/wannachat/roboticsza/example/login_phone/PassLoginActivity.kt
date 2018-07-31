package com.wannachat.roboticsza.example.login_phone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.wannachat.roboticsza.example.R
import kotlinx.android.synthetic.main.activity_pass_login.*
import org.jetbrains.anko.startActivity

class PassLoginActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_login)
        btnLogout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btnLogout -> {
                FirebaseAuth.getInstance().signOut()
                startActivity<MainActivity>()
                finish()
            }
        }
    }
}

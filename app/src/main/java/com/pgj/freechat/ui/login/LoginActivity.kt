package com.pgj.freechat.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.pgj.freechat.R

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    val viewModel by lazy{
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    private fun showSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }

    private fun showFailure() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {

    }
}
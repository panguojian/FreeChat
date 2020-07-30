package com.pgj.freechat.ui.login

import androidx.lifecycle.ViewModel
import com.pgj.freechat.callback.LoginCallback
import com.pgj.freechat.data.bean.User
import com.pgj.freechat.data.repository.LoginRepository

class LoginViewModel:ViewModel() {

    /**
     * 登录方法
     */
    private fun login(user:User){
        LoginRepository.login(user,object : LoginCallback{
            override fun onSuccess() {

            }

            override fun onFailure() {

            }

        })
    }
}
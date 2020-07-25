package com.pgj.freechat.ui.chat

import android.app.ProgressDialog
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.pgj.freechat.R

import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*

class ChatActivity : AppCompatActivity(),View.OnClickListener {
    val viewModel by lazy {
        ViewModelProviders.of(this).get(ChatViewModel::class.java)
    }
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var progressDialog: AppCompatDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(Build.VERSION.SDK_INT>=21){
            val decorView=window.decorView
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.statusBarColor= Color.TRANSPARENT
        }
        setContentView(R.layout.activity_chat)

        progressDialog= AppCompatDialog(this)

        val layoutManager=LinearLayoutManager(this)
        rv_chat.layoutManager=layoutManager
        chatAdapter=ChatAdapter(viewModel.dataList)
        rv_chat.adapter=chatAdapter

        btn_sendMsg.setOnClickListener (this)

        viewModel.msgList.observe(this, Observer {
            viewModel.dataList.clear()
            viewModel.dataList.addAll(it)
            chatAdapter.notifyDataSetChanged()
            rv_chat.scrollToPosition(viewModel.dataList.size-1)
        })

        viewModel.refresh()
    }

    override fun onClick(view: View?) {
        if(getInput().isNotEmpty()){

            viewModel.sendMsg(getInput())
            et_input.setText("")

        }else{
            Toast.makeText(this,"发送内容不能为空",Toast.LENGTH_SHORT).show()
        }
    }

    //获取要发送的文本框内容
    private fun getInput()=et_input.text.toString()


}
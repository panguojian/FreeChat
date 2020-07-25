package com.pgj.freechat.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.pgj.freechat.data.bean.Chat
import com.pgj.freechat.data.repository.ChatRepository
import java.util.*

class ChatViewModel:ViewModel() {



    val dataList=ArrayList<Chat>()


    //发送信息
    fun sendMsg(content:String){
        ChatRepository.sendMsg(content)
        refresh()
    }

    //获取聊天记录
    private val refreshLiveData=MutableLiveData<Any?>()
    val msgList=Transformations.switchMap(refreshLiveData){
        ChatRepository.getMsg()
    }
    fun refresh(){
        refreshLiveData.value=refreshLiveData.value
    }
}
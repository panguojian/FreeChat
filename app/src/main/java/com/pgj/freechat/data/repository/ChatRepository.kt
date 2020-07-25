package com.pgj.freechat.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.pgj.freechat.data.bean.Chat
import kotlinx.coroutines.Dispatchers
import java.util.*

object ChatRepository {

    //消息列表
    val database= ArrayList<Chat>()


    init {
        database.add(Chat(1,Chat.TYPE_RECEIVED,1,2,"Hello,PGJ",Date()))
        database.add(Chat(1,Chat.TYPE_SENT,1,2,"Hi,Xiaoming",Date()))
        database.add(Chat(1,Chat.TYPE_SENT,1,2,"How do you do?",Date()))
        database.add(Chat(1,Chat.TYPE_RECEIVED,1,2,"Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~" +
                "Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~Good nice~" +
                "Good nice~Good nice~Good nice~v",Date()))
    }


    //模拟发送消息的方法
    fun sendMsg(content:String){
        val chat=Chat(1,Chat.TYPE_SENT,1,2,content,Date())
        database.add(chat)
    }

    //模拟从数据库中获取聊天信息
    fun getMsg():LiveData<ArrayList<Chat>>{
        val msgList=MutableLiveData<ArrayList<Chat>>()
        msgList.value= database
        return msgList
    }

}
package com.pgj.freechat.data.bean

import java.util.*

class Chat(val id:Int,val type:Int,val sender:Int,val receiver:Int,val content:String,val time: Date){
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }
}
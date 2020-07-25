package com.pgj.freechat.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.pgj.freechat.R
import com.pgj.freechat.data.bean.Chat

class ChatAdapter(private val dataList:ArrayList<Chat>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class LeftViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv_chatcontent_left=view.findViewById<TextView>(R.id.tv_chatcontent_left)

    }

    inner class RightViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv_chatcontent_right=view.findViewById<TextView>(R.id.tv_chatcontent_right)

    }

    override fun getItemViewType(position: Int): Int {
        val chat=dataList[position]
        return chat.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == Chat.TYPE_RECEIVED) {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_left_chat, parent, false)
        LeftViewHolder(view)
    } else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_right_chat, parent, false)
        RightViewHolder(view)
    }

    override fun getItemCount()=dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = dataList[position]
        when (holder) {
            is LeftViewHolder -> holder.tv_chatcontent_left.text = chat.content
            is RightViewHolder -> holder.tv_chatcontent_right.text = chat.content
        }
    }
}
package com.pgj.freechat.ui.msg

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pgj.freechat.R
import com.pgj.freechat.data.bean.Msg
import com.pgj.freechat.ui.chat.ChatActivity

class MsgAdapter(private val context: Context?,private val dataList:ArrayList<Msg>):RecyclerView.Adapter<MsgAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iv_usericon=view.findViewById<ImageView>(R.id.iv_usericon)
        val tv_username=view.findViewById<TextView>(R.id.tv_username)
        val tv_msgcontent=view.findViewById<TextView>(R.id.tv_msgcontent)
        val tv_msgtime=view.findViewById<TextView>(R.id.tv_msgtime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_msg,parent,false)
        val viewHolder=ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val intent=Intent(context,ChatActivity::class.java)
            context?.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount()=dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}
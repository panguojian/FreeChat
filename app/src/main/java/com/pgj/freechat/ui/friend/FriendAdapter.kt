package com.pgj.freechat.ui.friend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pgj.freechat.R
import com.pgj.freechat.data.bean.Friend
import java.util.ArrayList

class FriendAdapter(private val friendList:ArrayList<Friend>) :RecyclerView.Adapter<FriendAdapter.ViewHolder>(){
    inner class ViewHolder(view:View) :RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_friend,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=friendList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}
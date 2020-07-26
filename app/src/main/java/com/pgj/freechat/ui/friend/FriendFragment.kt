package com.pgj.freechat.ui.friend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pgj.freechat.R
import com.pgj.freechat.data.bean.Friend
import kotlinx.android.synthetic.main.fragment_friend.*
import java.util.ArrayList

class FriendFragment :Fragment() {
    private val friendList=ArrayList<Friend>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friend,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager=LinearLayoutManager(context)
        rv_friend.layoutManager=layoutManager
        initData()
        val friendAdapter=FriendAdapter(friendList)
        rv_friend.adapter=friendAdapter

        sr_friend.setOnRefreshListener {
            sr_friend.isRefreshing=false
            Toast.makeText(context,"更新好友列表成功",Toast.LENGTH_SHORT).show()
        }
    }
    private fun initData(){
        for(i in 0..20){
            val friend=Friend()
            friendList.add(friend)
        }
    }
}
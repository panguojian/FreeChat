package com.pgj.freechat.ui.msg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pgj.freechat.R
import kotlinx.android.synthetic.main.fragment_msg.*

class MsgFragment : Fragment() {
    val viewModel by lazy {
        ViewModelProviders.of(this).get(MsgViewModel::class.java)
    }
    private lateinit var msgAdapter: MsgAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_msg,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager= LinearLayoutManager(context)
        rv_msg.layoutManager=layoutManager
        msgAdapter= MsgAdapter(context,viewModel.dataList)
        rv_msg.adapter=msgAdapter
    }
}
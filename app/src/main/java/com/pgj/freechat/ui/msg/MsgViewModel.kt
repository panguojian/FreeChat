package com.pgj.freechat.ui.msg

import androidx.lifecycle.ViewModel
import com.pgj.freechat.data.bean.Msg
import java.util.*

class MsgViewModel:ViewModel() {
    val dataList= arrayListOf<Msg>(
        Msg(
            1,
            "你好",
            Date()
        ),
        Msg(1, "你好", Date()),
        Msg(1, "你好", Date())
    )
}
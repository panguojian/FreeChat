package com.pgj.freechat.ui

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pgj.freechat.R
import com.pgj.freechat.ui.explore.ExploreFragment
import com.pgj.freechat.ui.friend.FriendFragment
import com.pgj.freechat.ui.msg.MsgFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,CompoundButton.OnCheckedChangeListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(Build.VERSION.SDK_INT>=21){
            val decorView=window.decorView
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.statusBarColor=Color.TRANSPARENT
        }
        setContentView(R.layout.activity_main)

        rb_msg.setOnCheckedChangeListener(this)
        rb_friend.setOnCheckedChangeListener(this)
        rb_explore.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        if(p1){
            when(p0?.id){
                R.id.rb_msg->{
                    replaceFragment(MsgFragment())
                }
                R.id.rb_friend->{
                    replaceFragment(FriendFragment())
                }
                R.id.rb_explore->{
                    replaceFragment(ExploreFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment,fragment)
            .commit()
    }
}
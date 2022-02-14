package com.nghiemtuananh.rxretrofitt3h

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate)
        iv_bitcoin.startAnimation(animRotate)
        btn_danhsach.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
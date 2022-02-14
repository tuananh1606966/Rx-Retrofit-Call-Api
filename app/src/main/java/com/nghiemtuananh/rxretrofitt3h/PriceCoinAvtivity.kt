package com.nghiemtuananh.rxretrofitt3h

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_price_coin_avtivity.*

class PriceCoinAvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_coin_avtivity)
        val animAlpha1 = AnimationUtils.loadAnimation(this, R.anim.anim_alpha1)
        val animAlpha2 = AnimationUtils.loadAnimation(this, R.anim.anim_alpha2)
        iv_nen_do.startAnimation(animAlpha1)
        iv_nen_xanh.startAnimation(animAlpha2)
        val nameCoin = intent.getStringExtra("nameCoin")
        tv_name_coin.setText(nameCoin)
        val priceCoin = intent.getStringExtra("price")
        tv_price.setText("$priceCoin USD")
        var change1h = intent.getDoubleExtra("change1h", 0.0)
        if (change1h < 0) {
            change1h = Math.abs(change1h)
            tv_change_1h.setText("Giảm $change1h %")
            tv_change_1h.setTextColor(Color.RED)
        } else {
            tv_change_1h.setText("Tăng $change1h %")
            tv_change_1h.setTextColor(Color.GREEN)
        }
        var change24h = intent.getDoubleExtra("change24h", 0.0)
        if (change24h < 0) {
            change24h = Math.abs(change24h)
            tv_change_24h.setText("Giảm $change24h %")
            tv_change_24h.setTextColor(Color.RED)
        } else {
            tv_change_24h.setText("Tăng $change24h %")
            tv_change_24h.setTextColor(Color.GREEN)
        }
        var change7d = intent.getDoubleExtra("change7d", 0.0)
        if (change7d < 0) {
            change7d = Math.abs(change7d)
            tv_change_7d.setText("Giảm $change7d %")
            tv_change_7d.setTextColor(Color.RED)
        } else {
            tv_change_7d.setText("Tăng $change7d %")
            tv_change_7d.setTextColor(Color.GREEN)
        }
        var change30d = intent.getDoubleExtra("change30d", 0.0)
        if (change30d < 0) {
            change30d = Math.abs(change30d)
            tv_change_30d.setText("Giảm $change30d %")
            tv_change_30d.setTextColor(Color.RED)
        } else {
            tv_change_30d.setText("Tăng $change24h %")
            tv_change_30d.setTextColor(Color.GREEN)
        }
    }
}
package com.nghiemtuananh.rxretrofitt3h

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var listCoin: ArrayList<String> = arrayListOf()
    lateinit var adapter: ArrayAdapter<String>
    var listPrice: ArrayList<String> = arrayListOf()
    var listChange1h: ArrayList<Double> = arrayListOf()
    var listChange24h: ArrayList<Double> = arrayListOf()
    var listChange7d: ArrayList<Double> = arrayListOf()
    var listChange30d: ArrayList<Double> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callApi()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listCoin)
        lv_coin.adapter = adapter
        lv_coin.setOnItemClickListener { parent, view, position, id ->
            intent = Intent(this, PriceCoinAvtivity::class.java)
            intent.putExtra("nameCoin", listCoin.get(position))
            intent.putExtra("price", listPrice.get(position))
            intent.putExtra("change1h", listChange1h.get(position))
            intent.putExtra("change24h", listChange24h.get(position))
            intent.putExtra("change7d", listChange7d.get(position))
            intent.putExtra("change30d", listChange30d.get(position))
            startActivity(intent)
        }
    }

    private fun callApi() {
        var cmapCoin: CmapCoinApi = CmapCoinFactor.createRetrofit()
        val header = HashMap<String, String>()
        header.put("X-CMC_PRO_API_KEY", "1a630ef7-031b-4f56-8d1d-faedda6e6203")
        var resOb: Observable<PricingCryptoCurrencyResponse> = cmapCoin.getCryptoCurrency(header)
        resOb.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    for (i in 0..it.data.size - 1) {
                        var name = it.data[i].name
                        var symbol = it.data[i].symbol
                        listCoin.add("$name - $symbol")
                        var price = it.data[i].quote.usd.price.toString()
                        listPrice.add(price)
                        var percentChange1h = it.data[i].quote.usd.percentChange1h
                        listChange1h.add(percentChange1h)
                        var percentChange24h = it.data[i].quote.usd.percentChange24h
                        listChange24h.add(percentChange24h)
                        var percentChange7d = it.data[i].quote.usd.percentChange7d
                        listChange7d.add(percentChange7d)
                        var percentChange30d = it.data[i].quote.usd.percentChange30d
                        listChange30d.add(percentChange30d)
                    }
                    adapter.notifyDataSetChanged()
                },
                {
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
                },
                {}
            )
    }
}
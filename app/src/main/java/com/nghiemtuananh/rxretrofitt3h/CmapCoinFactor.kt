package com.nghiemtuananh.rxretrofitt3h

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CmapCoinFactor {
    fun createRetrofit(): CmapCoinApi {
        return Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CmapCoinApi::class.java)
    }
}
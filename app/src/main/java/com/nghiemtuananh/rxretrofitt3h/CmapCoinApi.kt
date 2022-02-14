package com.nghiemtuananh.rxretrofitt3h

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface CmapCoinApi {
    @GET("/v1/cryptocurrency/listings/latest")
    fun getCryptoCurrency(
        @HeaderMap headerMap: Map<String, String>,
        @Query("start") start: Int = 1,
        @Query("limit") limit: Int = 100
    ): Observable<PricingCryptoCurrencyResponse>
}
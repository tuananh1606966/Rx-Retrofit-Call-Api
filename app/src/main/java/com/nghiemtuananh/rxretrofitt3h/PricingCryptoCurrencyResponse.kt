package com.nghiemtuananh.rxretrofitt3h

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("error_code")
    var errorCode: Int,
)

data class USD(
    var price: Double,
    @SerializedName("percent_change_1h")
    var percentChange1h: Double,
    @SerializedName("percent_change_24h")
    var percentChange24h: Double,
    @SerializedName("percent_change_7d")
    var percentChange7d: Double,
    @SerializedName("percent_change_30d")
    var percentChange30d: Double,
)

data class Quote(
    @SerializedName("USD")
    var usd: USD,
)

data class DataResponse(
    var name: String,
    var symbol: String,
    var quote: Quote,
)

data class PricingCryptoCurrencyResponse(
    var status: Status,
    var data: MutableList<DataResponse> = mutableListOf(),
)
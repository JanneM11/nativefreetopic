package com.example.freetopicnativeapp.model

import com.google.gson.annotations.SerializedName

data class BTC(
    @SerializedName("price_usd")
    var priceUsd: String
)

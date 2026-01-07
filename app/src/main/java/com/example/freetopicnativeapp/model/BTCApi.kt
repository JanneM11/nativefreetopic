package com.example.freetopicnativeapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.coinlore.net/api/"

interface BTCApi {
    @GET("ticker/?id=90")
    suspend fun getBTC(): List<BTC>
    companion object {
        var btcService: BTCApi? = null
        fun getInstance(): BTCApi {
            if (btcService === null) {
                btcService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(BTCApi::class.java)
            }
            return btcService!!
        }
    }
}
package com.aryan.stockmarketapp.data.remote.dto

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apikey: String = API_KEY
    ): ResponseBody

    companion object {
        const val API_KEY = "8SXKKEAJ7BBT66AV"
        const val BASE_URL = "https://www.alphavantage.co"
    }
}
package com.dicoding.stockpred.retrofit

import com.dicoding.stockpred.PredictInput
import com.dicoding.stockpred.PredictionResponse
import com.dicoding.stockpred.StockDetail
import com.dicoding.stockpred.StockItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    // Endpoint untuk mendapatkan daftar saham (Home.kt)
    @GET("/stocks")
    fun getStocks(): Call<List<StockItem>>

    // Endpoint untuk mendapatkan detail saham (DetailStockActivity.kt)
    @GET("/stock/{code}")
    fun getStockDetail(@Path("code") code: String): Call<StockDetail>

    // Endpoint untuk mendapatkan prediksi (PredictResult.kt)
    @GET("/predictions")
    fun getPredictions(): Call<PredictionResponse>

    // Endpoint untuk mengirim input (Predict.kt)
    @POST("/predict")
    fun submitPredictionInput(@Body input: PredictInput): Call<PredictionResponse>
}

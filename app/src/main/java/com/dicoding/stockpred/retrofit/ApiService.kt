package com.dicoding.stockpred.retrofit

import com.dicoding.stockpred.Predict
import com.dicoding.stockpred.PredictionResponse
import com.dicoding.stockpred.data.StockResponseItem
import com.dicoding.stockpred.data.StockPredictResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    // Endpoint untuk mendapatkan daftar saham
    @GET("/stocks")
    fun getStocks(): Call<List<StockResponseItem>>  // Mendapatkan daftar saham, hasilnya berupa list StockResponseItem

    // Endpoint untuk mendapatkan detail saham
    @GET("/stock/{code}")
    fun getStockDetail(@Path("code") code: String): Call<StockResponseItem>  // Mendapatkan detail saham berdasarkan kode saham

    // Endpoint untuk mendapatkan prediksi saham
    @GET("/predictions")
    fun getPredictions(): Call<StockPredictResponse>  // Mendapatkan prediksi hasil saham, berupa StockPredictResponse

    // Endpoint untuk mengirimkan input untuk prediksi
    @POST("/predict")
    fun submitPredictionInput(@Body input: Predict): Call<PredictionResponse>  // Mengirimkan input untuk prediksi, berupa PredictInput
}
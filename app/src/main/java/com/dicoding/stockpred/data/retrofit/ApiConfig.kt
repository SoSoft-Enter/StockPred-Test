package com.dicoding.stockpred.data.retrofit

import com.dicoding.stockpred.data.retrofit.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            // Membuat HttpLoggingInterceptor untuk log request dan response HTTP
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            // Membuat OkHttpClient dan menambahkan interceptor
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            // Retrofit untuk mengakses API
            val retrofit = Retrofit.Builder()
                // Ganti baseUrl dengan URL API yang sesuai
                .baseUrl("https://stockpredapi-447282078912.asia-southeast2.run.app")
                .addConverterFactory(GsonConverterFactory.create())  // Gunakan GsonConverterFactory untuk konversi JSON ke objek
                .client(client)  // Menambahkan OkHttpClient dengan logging interceptor
                .build()

            // Mengembalikan instance ApiService untuk digunakan di aplikasi
            return retrofit.create(ApiService::class.java)
        }
    }
}
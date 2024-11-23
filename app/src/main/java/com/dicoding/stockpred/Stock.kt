package com.dicoding.stockpred

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stock(
    val name: String,
    val description: String,
    val photo: Int,
    val price: String
) : Parcelable

data class StockItem(
    val code: String,
    val logo: String
)

data class StockDetail(
    val code: String,
    val name: String,
    val logo: String,
    val sector: String,
    val description: String,
    val website: String
)

data class PredictionResponse(
    val prediction: Map<String, String>
)

data class PredictInput(
    val exchange_rate: Int,
    val bi_rate: Double,
    val inflation_rate: Double
)

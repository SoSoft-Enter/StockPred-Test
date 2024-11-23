package com.dicoding.stockpred.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "stock_response_item") // Menandakan bahwa ini adalah entitas Room
@Parcelize // Menambahkan Parcelable untuk serialisasi
data class StockResponseItem(

    @PrimaryKey @SerializedName("code") val code: String, // Menggunakan kode sebagai primary key

    @SerializedName("website") val website: String,
    @SerializedName("name") val name: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("description") val description: String,
    @SerializedName("sector") val sector: String
) : Parcelable

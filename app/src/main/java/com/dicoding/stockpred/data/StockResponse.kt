package com.dicoding.stockpred.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class StockResponse(

	@field:SerializedName("StockResponse")
	val stockResponse: List<StockResponseItem>
) : Parcelable

@Parcelize
data class StockResponseItem(

	@field:SerializedName("website")
	val website: String,

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("logo")
	val logo: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("sector")
	val sector: String
) : Parcelable

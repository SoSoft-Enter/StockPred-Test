package com.dicoding.stockpred.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class StockResponse(

	@field:SerializedName("StockResponse")
	val stockResponse: List<StockResponseItem>
) : Parcelable


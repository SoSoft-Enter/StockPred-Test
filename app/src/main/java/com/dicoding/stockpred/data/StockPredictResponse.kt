package com.dicoding.stockpred.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class StockPredictResponse(

	@field:SerializedName("prediction")
	val prediction: Prediction
) : Parcelable

@Parcelize
data class Prediction(

	@field:SerializedName("JPFA")
	val jPFA: String,

	@field:SerializedName("PWON")
	val pWON: String,

	@field:SerializedName("INDF")
	val iNDF: String,

	@field:SerializedName("KLBF")
	val kLBF: String,

	@field:SerializedName("DUTI")
	val dUTI: String,

	@field:SerializedName("ITMG")
	val iTMG: String,

	@field:SerializedName("ICBP")
	val iCBP: String,

	@field:SerializedName("ULTJ")
	val uLTJ: String,

	@field:SerializedName("ASII")
	val aSII: String,

	@field:SerializedName("JSMR")
	val jSMR: String,

	@field:SerializedName("BSDE")
	val bSDE: String,

	@field:SerializedName("SMAR")
	val sMAR: String,

	@field:SerializedName("ACES")
	val aCES: String,

	@field:SerializedName("JRPT")
	val jRPT: String,

	@field:SerializedName("SMSM")
	val sMSM: String,

	@field:SerializedName("EPMT")
	val ePMT: String,

	@field:SerializedName("TSPC")
	val tSPC: String,

	@field:SerializedName("TLKM")
	val tLKM: String,

	@field:SerializedName("CTRA")
	val cTRA: String,

	@field:SerializedName("SMCB")
	val sMCB: String
) : Parcelable

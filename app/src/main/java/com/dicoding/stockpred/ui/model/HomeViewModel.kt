package com.dicoding.stockpred.ui.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.stockpred.apaini.StockResponseItem
import com.dicoding.stockpred.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    // Private LiveData untuk menyimpan data stockList
    private val _stockList = MutableLiveData<List<StockResponseItem>>()
    val stockList: LiveData<List<StockResponseItem>> get() = _stockList

    // LiveData untuk menampilkan status loading
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    // Fungsi untuk mengambil data saham dari API
    fun fetchStocks() {
        _loading.value = true
        val apiService = ApiConfig.getApiService()
        apiService.getStocks().enqueue(object : Callback<List<StockResponseItem>> {
            override fun onResponse(
                call: Call<List<StockResponseItem>>,
                response: Response<List<StockResponseItem>>
            ) {
                _loading.value = false
                if (response.isSuccessful) {
                    _stockList.value = response.body()
                } else {
                    // Tangani kegagalan respons API
                    _stockList.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<StockResponseItem>>, t: Throwable) {
                _loading.value = false
                // Tangani error jaringan
                _stockList.value = emptyList()
            }
        })
    }
}

package com.dicoding.stockpred.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dicoding.stockpred.data.StockResponseItem

@Dao
interface StockDao {

    @Insert
    suspend fun insert(stockResponseItem: StockResponseItem)

    @Query("SELECT * FROM stock_response_item WHERE code = :code")
    suspend fun getStockByCode(code: String): StockResponseItem?

    @Query("SELECT * FROM stock_response_item")
    suspend fun getAllStocks(): List<StockResponseItem>

    @Query("DELETE FROM stock_response_item WHERE code = :code")
    suspend fun deleteStockByCode(code: String)
}

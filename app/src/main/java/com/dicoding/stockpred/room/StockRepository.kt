package com.dicoding.stockpred.room

import android.content.Context
import androidx.room.Room
import com.dicoding.stockpred.data.StockResponseItem

class StockRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context,
        StockDatabase::class.java, "stock-database"
    ).build()

    private val stockDao = db.stockDao() // Ganti sesuai nama DAO

    suspend fun getAllStocks(): List<StockResponseItem> {
        return stockDao.getAllStocks()
    }

    suspend fun getStockByCode(code: String): StockResponseItem? {
        return stockDao.getStockByCode(code)
    }

    suspend fun insertStock(stockResponseItem: StockResponseItem) {
        stockDao.insert(stockResponseItem)
    }

    suspend fun deleteStockByCode(code: String) {
        stockDao.deleteStockByCode(code)
    }
}

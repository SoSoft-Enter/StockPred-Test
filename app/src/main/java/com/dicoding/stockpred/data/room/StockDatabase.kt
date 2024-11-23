package com.dicoding.stockpred.data.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.stockpred.apaini.StockResponseItem


@Database(entities = [StockResponseItem::class], version = 1)
abstract class StockDatabase : RoomDatabase() {
    abstract fun stockResponseItemDao(): StockDao
}


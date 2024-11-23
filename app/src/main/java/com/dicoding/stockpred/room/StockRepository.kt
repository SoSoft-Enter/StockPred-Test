import android.content.Context
import androidx.room.Room
import com.dicoding.stockpred.room.StockDatabase
import com.dicoding.stockpred.data.StockResponseItem

class StockRepository(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        StockDatabase::class.java, "stock-database"
    ).build()

    private val stockDao = db.stockResponseItemDao()

    suspend fun getAllStocks(): List<com.dicoding.stockpred.data.StockResponseItem> {
        return stockDao.getAllStocks()
    }

    suspend fun getStockByCode(code: String): com.dicoding.stockpred.data.StockResponseItem? {
        return stockDao.getStockByCode(code)
    }

    suspend fun insertStock(stockResponseItem: StockResponseItem) {
        stockDao.insert(stockResponseItem)
    }

    suspend fun deleteStockByCode(code: String) {
        stockDao.deleteStockByCode(code)
    }
}


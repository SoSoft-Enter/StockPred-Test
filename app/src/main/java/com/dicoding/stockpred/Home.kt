package com.dicoding.stockpred

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.stockpred.detail.DetailStockActivity

class Home : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var stockAdapter: StockAdapter
    private lateinit var stockList: ArrayList<Stock>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.rv_stock)

        // Mengambil data dari strings.xml
        val stockCodes = resources.getStringArray(R.array.stock_code)
        val stockNames = resources.getStringArray(R.array.stock_name)

        // Memastikan jumlah stockCode dan stockName sama
        if (stockCodes.size == stockNames.size) {
            stockList = ArrayList()
            for (i in stockCodes.indices) {
                // Menambahkan data ke list dengan foto placeholder
                stockList.add(Stock(stockNames[i], stockCodes[i], R.drawable.placeholder_logo))
            }
        }

        // Set up the RecyclerView with the adapter
        stockAdapter = StockAdapter(stockList) { stock ->
            // Panggil DetailStockActivity ketika item diklik
            val intent = Intent(activity, DetailStockActivity::class.java).apply {
                putExtra("EXTRA_STOCK", stock) // Kirim data stock
            }
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = stockAdapter

        return view
    }
}
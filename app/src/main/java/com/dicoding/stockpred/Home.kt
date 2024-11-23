package com.dicoding.stockpred

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.stockpred.detail.DetailStockActivity
import com.dicoding.stockpred.viewmodel.HomeViewModel
import com.dicoding.stockpred.viewmodel.factory.HomeViewModelFactory

class Home : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var stockAdapter: StockAdapter<Any?>
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.rv_stock)

        // Menggunakan HomeViewModelFactory untuk mendapatkan HomeViewModel
        homeViewModel = ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]

        // Mengamati perubahan stockList untuk memperbarui UI
        homeViewModel.stockList.observe(viewLifecycleOwner) { stockData ->
            stockAdapter = StockAdapter(stockData) { stock ->
                val intent = Intent(activity, DetailStockActivity::class.java).apply {
                    putExtra("EXTRA_STOCK", stock)
                }
                startActivity(intent)
            }

            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = stockAdapter
        }

        // Mengamati status loading untuk menampilkan progress bar
        homeViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            view.findViewById<ProgressBar>(R.id.progressBar).visibility =
                if (isLoading) View.VISIBLE else View.GONE
        }


        // Memanggil fetchStocks untuk mengambil data dari API
        homeViewModel.fetchStocks()

        return view
    }
}

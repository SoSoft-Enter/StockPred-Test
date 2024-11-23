package com.dicoding.stockpred.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.stockpred.R
import com.dicoding.stockpred.apaini.StockResponseItem

class StockAdapter(
    private val listStock: List<StockResponseItem>, // Menggunakan StockResponseItem
    private val onItemClick: (StockResponseItem) -> Unit // Mengirimkan StockResponseItem pada klik
) : RecyclerView.Adapter<StockAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_stock_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_stock_code)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_stock, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listStock.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val stock = listStock[position]

        // Menampilkan logo menggunakan gambar yang sesuai
        holder.imgPhoto.setImageResource(stock.logo)

        // Menampilkan nama dan deskripsi saham
        holder.tvName.text = stock.name
        holder.tvDescription.text = stock.description

        // Tidak ada lagi bagian harga, jadi kita hapus bagian ini
        // holder.itemView.findViewById<TextView>(R.id.tv_stock_price).text = "Rp ${stock.price}"

        holder.itemView.setOnClickListener {
            onItemClick(stock)
        }
    }
}


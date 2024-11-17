package com.dicoding.stockpred

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.button.MaterialButton

object DialogUtil {

    fun showNoInternetDialog(context: Context, layoutInflater: LayoutInflater) {
        val builder = AlertDialog.Builder(context)
        val dialogView = layoutInflater.inflate(R.layout.custom_alert_dialog, null)

        builder.setView(dialogView)
        val dialog = builder.create()

        val btnClose = dialogView.findViewById<MaterialButton>(R.id.btnClose)
        btnClose.setOnClickListener {
            dialog.dismiss() // Menutup dialog
            if (context is Activity) {
                context.finishAffinity() // Menutup aplikasi
            }
        }

        dialog.setCancelable(false) // Mencegah dialog ditutup dengan tombol back
        dialog.show()
    }
}

package com.dicoding.stockpred

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.dicoding.stockpred.input.PredictResult
import com.google.android.material.textfield.TextInputLayout
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

class Predict : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_predict, container, false)

        // Set click listener for the "Input" button
        view.findViewById<Button>(R.id.buttonInput).setOnClickListener {
            // Navigasi ke PredictResultActivity saat tombol "Input" diklik
            val intent = Intent(activity, PredictResult::class.java)
            startActivity(intent)
        }

        // Set click listener for the "Clear" button
        view.findViewById<Button>(R.id.buttonClear).setOnClickListener {
            // Mengakses TextInputEditText melalui TextInputLayout
            val input1 = view.findViewById<TextInputLayout>(R.id.textInputLayout1).editText
            val input2 = view.findViewById<TextInputLayout>(R.id.textInputLayout2).editText
            val input3 = view.findViewById<TextInputLayout>(R.id.textInputLayout3).editText

            // Menghapus teks dari semua input
            input1?.setText("")  // Clear input 1
            input2?.setText("")  // Clear input 2
            input3?.setText("")  // Clear input 3
        }

        return view
    }

}

package com.example.algeriansupremecourt.features.settings

// Inside your Settings fragment class

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.algeriansupremecourt.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.widget.Button
import android.net.Uri


class Settings : Fragment() {

    // Define your data model
    data class ArretData(
        val NumArret: String,
        val ChambreArret: String,
        val RefArret: String,
        val AnneeRef: String,
        val numRef: String,
        val numPageRef: String,
        val DateArret: String,
        val PartiesArret: String,
        val PrincipeArret: String,
        val DecisionArret: String,
        val DecisionOpArret: String,
        val CompositionArret: String
    )

    private val FILE_PICKER_REQUEST_CODE = 123


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access your views and set up click listeners here
        val btnLoadData = view.findViewById<Button>(R.id.btnLoadData)
        btnLoadData.setOnClickListener {
            // Call a function to handle loading data from JSON
            openFilePicker()
        }
    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/json" // Set the MIME type for JSON files
        }

        startActivityForResult(intent, FILE_PICKER_REQUEST_CODE)
    }

    // Handle the result of the file picker
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { fileUri ->
                // Call a function to handle loading data from the selected JSON file
                loadDataFromJson(fileUri)
            }
        }
    }

    private fun loadDataFromJson(fileUri: Uri) {
        try {
            val inputStream = requireContext().contentResolver.openInputStream(fileUri)
            val size = inputStream?.available() ?: 0
            val buffer = ByteArray(size)
            inputStream?.read(buffer)
            inputStream?.close()
            val json = String(buffer)

            // Parse JSON using Gson into a list of your data model
            val listType = object : TypeToken<List<ArretData>>() {}.type
            val dataList: List<ArretData> = Gson().fromJson(json, listType)

            // TODO: Store dataList in your local database (SQLite or Room)

            // TODO: Notify the user that data has been loaded successfully
        } catch (e: Exception) {
            // Handle exceptions (e.g., JSON parsing error, file not found, etc.)
            // TODO: Notify the user about the error
        }
    }
}

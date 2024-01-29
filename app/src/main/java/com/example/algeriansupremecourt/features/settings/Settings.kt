package com.example.algeriansupremecourt.features.settings

// Inside your Settings fragment class

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.algeriansupremecourt.R
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
import android.widget.Button
import android.net.Uri
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.algeriansupremecourt.database.ArretDatabase
import com.example.algeriansupremecourt.features.arret.ArretModel
import com.example.algeriansupremecourt.features.arret.ArretViewModel
import com.example.algeriansupremecourt.features.arret.ArretViewModelFactory
import com.example.algeriansupremecourt.repository.ArretRepo
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinx.coroutines.launch


class Settings : Fragment() {

    // Define your data model


    private val FILE_PICKER_REQUEST_CODE = 123
    private val arretViewModel:ArretViewModel by viewModels{
        ArretViewModelFactory((requireActivity().application))
    }

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
        val btnClearDB = view.findViewById<Button>(R.id.btnDeleteData)


        btnLoadData.setOnClickListener {
            // Call a function to handle loading data from JSON
            openFilePicker()
        }

        btnClearDB.setOnClickListener {
            lifecycleScope.launch {
                arretViewModel.deleteAllArrets()
            }
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

                loadDataFromJson(fileUri,requireContext())
            }
        }
    }
    private fun loadDataFromJson(fileUri: Uri,context: Context)  {
        try {
            val inputStream = context.contentResolver.openInputStream(fileUri)
            val size = inputStream?.available() ?: 0
            val buffer = ByteArray(size)
            inputStream?.read(buffer)
            inputStream?.close()
            val jsonString = String(buffer)
            // Parse JSON using Gson into a list of your data model
            val listType = object : TypeToken<List<ArretModel>>() {}.type
            val dataList: List<ArretModel> = Gson().fromJson(jsonString, listType)

            // TODO: Store dataList in your local database (SQLite or Room)
        arretViewModel.insertArretsFromJson(dataList)

            Log.d("json", dataList[0].dateArret)
        } catch (e: Exception) {
            // Handle exceptions (e.g., JSON parsing error, file not found, etc.)
            // TODO: Notify the user about the error
            Log.e("json","Error " + e.message)
        }
    }

}


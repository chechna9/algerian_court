package com.example.algeriansupremecourt.features.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.algeriansupremecourt.R
import com.example.algeriansupremecourt.features.arret.ArretAdapter
import com.example.algeriansupremecourt.features.arret.ArretDetailDialogFragment
import com.example.algeriansupremecourt.features.arret.ArretModel
import com.example.algeriansupremecourt.features.arret.ArretViewModel
import com.example.algeriansupremecourt.features.arret.ArretViewModelFactory
import kotlinx.coroutines.launch

class Home : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val arretViewModel: ArretViewModel by viewModels {
        ArretViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner1: Spinner = view.findViewById(R.id.spinnerFilter1)
        val spinner2: Spinner = view.findViewById(R.id.spinnerFilter2)
        val spinner3: Spinner = view.findViewById(R.id.spinnerFilter3)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.years_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.source_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.chambre_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter = adapter
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        getAllArrets()
    }

    private fun getAllArrets() {
        val adapter = ArretAdapter() // Initially, an empty list

        lifecycleScope.launch {
            arretViewModel.allArrets().observe(viewLifecycleOwner, Observer { arrets ->
                adapter.updateData(arrets) // Update the adapter with the new data
            })
        }
        adapter.onItemClick = {arret -> navigateToDetailDialog(arret)}
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
    private fun navigateToDetailDialog(arret: ArretModel) {
        val detailDialogFragment = ArretDetailDialogFragment(arret)
        detailDialogFragment.show(childFragmentManager, detailDialogFragment.tag)
    }

}

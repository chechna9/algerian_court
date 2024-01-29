package com.example.algeriansupremecourt.features.arret

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.example.algeriansupremecourt.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.algeriansupremecourt.features.arret.ArretModel

class ArretDetailDialogFragment(private val arret: ArretModel) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_arret_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewNumArret: TextView = view.findViewById(R.id.textViewNumArret)
        val textViewChambreArret: TextView = view.findViewById(R.id.textViewChambreArret)
        val textViewRefArret: TextView = view.findViewById(R.id.textViewRefArret)
        val textViewAnneeRef: TextView = view.findViewById(R.id.textViewAnneeRef)
        val textViewNumRef: TextView = view.findViewById(R.id.textViewNumRef)
        val textViewNumPageRef: TextView = view.findViewById(R.id.textViewNumPageRef)
        val textViewDateArret: TextView = view.findViewById(R.id.textViewDateArret)
        val textViewPartiesArret: TextView = view.findViewById(R.id.textViewPartiesArret)
        val textViewPrincipeArret: TextView = view.findViewById(R.id.textViewPrincipeArret)
        val textViewDecisionArret: TextView = view.findViewById(R.id.textViewDecisionArret)
        val textViewDecisionOpArret: TextView = view.findViewById(R.id.textViewDecisionOpArret)
        val textViewCompositionArret: TextView = view.findViewById(R.id.textViewCompositionArret)

        textViewNumArret.text = "رقم القرار: ${arret.numArret}"
        textViewChambreArret.text = "غرفة القرار: ${arret.chambreArret}"
        textViewRefArret.text = "مرجع القرار: ${arret.refArret}"
        textViewAnneeRef.text = "سنة المرجع: ${arret.anneeRef}"
        textViewNumRef.text = "رقم المرجع: ${arret.numRef}"
        textViewNumPageRef.text = "رقم الصفحة المرجعية: ${arret.numPageRef}"
        textViewDateArret.text = "تاريخ القرار: ${arret.dateArret}"
        textViewPartiesArret.text = "أطراف القرار: ${arret.partiesArret}"
        textViewPrincipeArret.text = "مبدأ القرار: ${arret.principeArret}"
        textViewDecisionArret.text = "قرار القضية: ${arret.decisionArret}"
        textViewDecisionOpArret.text = "قرار الهيئة القضائية: ${arret.decisionOpArret}"
        textViewCompositionArret.text = "تكوين الهيئة القضائية: ${arret.compositionArret}"

    }
}

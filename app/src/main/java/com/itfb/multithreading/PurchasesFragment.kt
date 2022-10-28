package com.itfb.multithreading

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

class PurchasesFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory: ViewModelProvider.Factory =
            PurchaseViewModelFactory()
        val model by viewModels<PurchasesViewModel> { factory }
        model.purchasesLiveData.observe(this){
            println(it)
        }

    }
}
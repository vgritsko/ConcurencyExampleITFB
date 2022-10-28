package com.itfb.multithreading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PurchaseViewModelFactory : ViewModelProvider.Factory {
    private val provider: PurchasesProvider =
        PurchasesProviderImpl()
    private val billingClient: BillingClient =
        BillingClientImpl(provider)
    private val user = "user"

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if
                (modelClass.isAssignableFrom(PurchasesViewModel::class.java)) {
            return PurchasesViewModel(billingClient, user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}
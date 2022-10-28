package com.itfb.multithreading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itfb.multithreading.model.UserPurchases

class PurchasesViewModel internal constructor(
    private val billingClient: BillingClient,
    private val user: String
) : ViewModel() {
    private var _purchases = MutableLiveData<UserPurchases>()
    private fun getUserPurchases(user: String) {
        billingClient.init { provider ->
            // вызывается из бэкграундного потока
            provider?.fetchPurchases(user) { purchases ->
                _purchases.postValue(UserPurchases(user, purchases))
            }
        }
    }
    val purchasesLiveData: LiveData<UserPurchases>
        get() {
            getUserPurchases(user)
            return _purchases
        }


}
package com.itfb.multithreading

interface BillingClient {
    fun interface BillingCallback {
        fun onInitDone(provider: PurchasesProvider?)
    }

    fun init(callback: BillingCallback)
}
package com.itfb.multithreading

import java.util.concurrent.Executors

class BillingClientImpl(private val purchasesProvider:
                        PurchasesProvider) : BillingClient {
    private val executor =
        Executors.newSingleThreadExecutor()
    override fun init(callback: BillingClient.BillingCallback) {
        /* perform asynchronous work here */
        executor.submit {
            try {
                Thread.sleep(1000)
                callback.onInitDone(purchasesProvider)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}

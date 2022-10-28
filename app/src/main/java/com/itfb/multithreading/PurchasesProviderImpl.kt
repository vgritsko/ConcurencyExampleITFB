package com.itfb.multithreading

import java.util.concurrent.Executors

class PurchasesProviderImpl : PurchasesProvider {
    private val executor =
        Executors.newSingleThreadExecutor()
    override fun fetchPurchases(
        user: String,
        callback: PurchasesProvider.PurchaseFetchCallback
    ) {
        /* asynchronous work */
        executor.submit {
            try {
                // Simulate blocking IO
                Thread.sleep(1000)
                callback.onPurchaseFetchDone(
                    listOf("Purchase1", "Purchase2")
                )
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}
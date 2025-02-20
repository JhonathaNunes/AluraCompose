package com.nunes.jhonatha.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.nunes.jhonatha.aluvery.models.Product

class ProductDAO {
    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }
}
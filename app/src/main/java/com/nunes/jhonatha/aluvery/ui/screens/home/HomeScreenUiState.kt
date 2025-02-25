package com.nunes.jhonatha.aluvery.ui.screens.home

import com.nunes.jhonatha.aluvery.models.Product

class HomeScreenUiState(
    val searchText: String = "",
    val sections: Map<String, List<Product>> = emptyMap(),
    val filteredProducts: List<Product> = emptyList(),
    val onSearchChange: (String) -> Unit = {}
) {
    fun shouldShowSections() = searchText.isBlank()
}
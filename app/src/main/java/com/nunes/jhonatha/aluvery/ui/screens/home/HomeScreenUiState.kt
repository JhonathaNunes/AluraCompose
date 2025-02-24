package com.nunes.jhonatha.aluvery.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nunes.jhonatha.aluvery.sampledata.sampleProducts

class HomeScreenUiState(searchText: String = "") {
    var text: String by mutableStateOf(searchText)
        private set

    val filteredProducts get() =
        if (text.isNotBlank()) {
            sampleProducts.filter {
                it.name.contains(text, ignoreCase = true) ||
                        it.description?.contains(text, ignoreCase = true) == true
            }
        } else {
            sampleProducts
        }

    fun shouldShowSections() = text.isBlank()

    val onSearchChange: (String) -> Unit = { searchText ->
        text = searchText
    }
}
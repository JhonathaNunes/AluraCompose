package com.nunes.jhonatha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nunes.jhonatha.aluvery.models.Product
import com.nunes.jhonatha.aluvery.sampledata.sampleCandies
import com.nunes.jhonatha.aluvery.sampledata.sampleDrinks
import com.nunes.jhonatha.aluvery.sampledata.sampleProducts
import com.nunes.jhonatha.aluvery.sampledata.sampleSections
import com.nunes.jhonatha.aluvery.ui.components.CardProductItem
import com.nunes.jhonatha.aluvery.ui.components.ProductsSection
import com.nunes.jhonatha.aluvery.ui.components.SearchTextField
import com.nunes.jhonatha.aluvery.ui.states.HomeScreenUiState
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(products: List<Product>) {
    var text by remember {
        mutableStateOf("")
    }

    val sections = mapOf(
        "Todos produtos" to products,
        "Promoções" to sampleCandies + sampleDrinks,
        "Bebidas" to sampleDrinks,
        "Doces" to sampleCandies
    )

    val filteredProducts = remember(text, products) {
        if (text.isNotBlank()) {
            (products + sampleProducts).filter {
                it.name.contains(text, ignoreCase = true) || it.description?.contains(
                    text,
                    ignoreCase = true
                ) == true
            }
        } else {
            products + sampleProducts
        }
    }

    val onTextChange = { searchText: String ->
        text = searchText
    }

    val homeScreenUiState = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchText = text,
            filteredProducts = filteredProducts,
            onSearchChange = onTextChange
        )
    }

    HomeScreen(
        state = homeScreenUiState
    )
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val text = state.searchText
        val sections = state.sections
        val filteredProducts = state.filteredProducts

        SearchTextField(
            searchText = text, onSearchChange = state.onSearchChange
        )

        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            if (state.shouldShowSections()) {
                sections.forEach { section ->
                    val title = section.key
                    val products = section.value

                    item {
                        ProductsSection(
                            title, products
                        )
                    }
                }
            } else {
                items(filteredProducts) { product ->
                    CardProductItem(product, Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(state = HomeScreenUiState(sections = sampleSections))
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(
                    searchText = "a", sections = sampleSections
                )
            )
        }
    }
}
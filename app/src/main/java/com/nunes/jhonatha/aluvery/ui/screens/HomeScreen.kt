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
import com.nunes.jhonatha.aluvery.sampledata.sampleProducts
import com.nunes.jhonatha.aluvery.sampledata.sampleSections
import com.nunes.jhonatha.aluvery.ui.components.CardProductItem
import com.nunes.jhonatha.aluvery.ui.components.ProductsSection
import com.nunes.jhonatha.aluvery.ui.components.SearchTextField
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        var text: String by remember { mutableStateOf(searchText) }
        val filteredProducts = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter {
                    it.name.contains(text, ignoreCase = true) ||
                            it.description?.contains(text, ignoreCase = true) == true
                }
            } else {
                sampleProducts
            }
        }

        SearchTextField(text) { newValue ->
            text = newValue
        }

        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            if (text.isBlank()) {
                sections.forEach { section ->
                    val title = section.key
                    val products = section.value

                    item {
                        ProductsSection(
                            title,
                            products
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
    HomeScreen(sampleSections)
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections, searchText = "a")
        }
    }
}
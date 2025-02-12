package com.nunes.jhonatha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nunes.jhonatha.aluvery.models.Product
import com.nunes.jhonatha.aluvery.sampledata.sampleProducts
import com.nunes.jhonatha.aluvery.ui.components.ProductItem
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

@Composable
fun AllProductsScreen(products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 48.dp, bottom = 32.dp)
    ) {
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Text("Todos produtos", fontWeight = FontWeight(400), fontSize = 21.sp)
        }

        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AllProductsScreenPreview() {
    AluveryTheme {
        Surface {
            AllProductsScreen(sampleProducts)
        }
    }
}
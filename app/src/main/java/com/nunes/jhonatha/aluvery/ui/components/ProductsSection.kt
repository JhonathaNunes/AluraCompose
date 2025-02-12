package com.nunes.jhonatha.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductsSection(
    title: String,
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            title,
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
        )
        LazyRow(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
        Surface {
            ProductsSection("Promoções", sampleProducts)
        }
    }
}
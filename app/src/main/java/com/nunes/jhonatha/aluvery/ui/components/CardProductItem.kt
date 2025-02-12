package com.nunes.jhonatha.aluvery.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.nunes.jhonatha.aluvery.R
import com.nunes.jhonatha.aluvery.extensions.toBrazilianCurrencyFormat
import com.nunes.jhonatha.aluvery.models.Product
import com.nunes.jhonatha.aluvery.sampledata.sampleProducts
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .animateContentSize()
            .clickable {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrencyFormat()
                )
            }

            product.description?.let {
                Text(
                    text = product.description,
                    Modifier
                        .padding(16.dp),
                    maxLines = if (expanded) Int.MAX_VALUE else  2,
                    overflow = if (expanded) TextOverflow.Clip else  TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                Product(
                    "Produto",
                    BigDecimal(14.99)
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                Product(
                    "Produto",
                    BigDecimal(14.99),
                    description = LoremIpsum(50).values.first()
                )
            )
        }
    }
}
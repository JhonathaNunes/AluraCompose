package com.nunes.jhonatha.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.nunes.jhonatha.aluvery.R
import com.nunes.jhonatha.aluvery.extensions.toBrazilianCurrencyFormat
import com.nunes.jhonatha.aluvery.models.Product
import java.math.BigDecimal

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier.width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = product.name,
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight(700),
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrencyFormat(),
                    Modifier.padding(top = 8.dp),
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal(12.99)
        )
    )
}
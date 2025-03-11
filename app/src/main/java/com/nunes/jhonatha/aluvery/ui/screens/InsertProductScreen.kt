package com.nunes.jhonatha.aluvery.ui.screens

import android.icu.text.DecimalFormat
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.nunes.jhonatha.aluvery.R
import com.nunes.jhonatha.aluvery.models.Product
import com.nunes.jhonatha.aluvery.ui.components.FormTextField
import com.nunes.jhonatha.aluvery.ui.states.InsertProductScreenUiState
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun InsertProductScreen(onSave: (Product) -> Unit) {
    var url by rememberSaveable {
        mutableStateOf("")
    }

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var price by rememberSaveable {
        mutableStateOf("")
    }

    var description by rememberSaveable {
        mutableStateOf("")
    }

    val formatter = DecimalFormat("#.##")

    InsertProductScreen(
        state = InsertProductScreenUiState(
            url = url,
            onUrlChange = { newUrl: String ->
                Log.i("Insert", "InsertProductScreen: $newUrl")
                url = newUrl
            },
            name = name,
            onNameChange = { newName: String ->
                name = newName
            },
            price = price,
            onPriceChange = { newPrice: String ->
                try {
                    price = formatter.format(BigDecimal(newPrice))
                } catch (e: IllegalArgumentException) {
                    if (newPrice.isEmpty()) price = newPrice
                }
            },
            description = description,
            onDescriptionChange = { newDescription: String ->
                description = newDescription
            }
        ),
        onSave = onSave
    )
}

@Composable
fun InsertProductScreen(
    state: InsertProductScreenUiState = InsertProductScreenUiState(),
    onSave: (Product) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val url = state.url
        val name = state.name
        val price = state.price
        val description = state.description

        Text(stringResource(R.string.add_product), fontSize = 28.sp)

        AnimatedVisibility(state.isUrlFilled()) {
            AsyncImage(
                model = url,
                contentDescription = "Image preview",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                placeholder = painterResource(R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
        }

        FormTextField(
            value = url,
            label = stringResource(R.string.image_url),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            onValueChange = state.onUrlChange
        )

        FormTextField(
            value = name,
            label = stringResource(R.string.name),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            onValueChange = state.onNameChange
        )

        FormTextField(
            value = price,
            label = stringResource(R.string.price),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next,
            ),
            onValueChange = state.onPriceChange
        )

        FormTextField(
            value = description,
            label = stringResource(R.string.description),
            Modifier.heightIn(min = 100.dp),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            onValueChange = state.onDescriptionChange
        )

        Button(
            onClick = {
                val priceConverted = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }

                val product = Product(
                    name = name,
                    price = priceConverted,
                    image = url,
                    description = description
                )

                Log.i("InsertProductScreen", "InsertProductScreen: $product")

                onSave(product)
            },
            Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4),
            elevation = ButtonDefaults.elevatedButtonElevation(10.dp)
        ) {
            Text(stringResource(R.string.save))
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun InsertProductScreenPreview() {
    AluveryTheme {
        Scaffold { innerPadding ->
            Surface(Modifier.padding(innerPadding)) {
                InsertProductScreen(onSave = {})
            }
        }
    }
}
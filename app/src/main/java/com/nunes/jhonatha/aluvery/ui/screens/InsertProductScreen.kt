package com.nunes.jhonatha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nunes.jhonatha.aluvery.R
import com.nunes.jhonatha.aluvery.ui.components.FormTextField
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

@Composable
fun InsertProductScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(stringResource(R.string.add_product), fontSize = 28.sp)

        var url by remember {
            mutableStateOf("")
        }

        FormTextField(
            value = url,
            label = stringResource(R.string.image_url)
        ) {
            url = it
        }

        var name by remember {
            mutableStateOf("")
        }

        FormTextField(
            value = name,
            label = stringResource(R.string.name)
        ) {
            name = it
        }

        var price by remember {
            mutableStateOf("")
        }

        FormTextField(
            value = price,
            label = stringResource(R.string.price)
        ) {
            price = it
        }

        var description by remember {
            mutableStateOf("")
        }

        FormTextField(
            value = description,
            label = stringResource(R.string.description),
            Modifier.heightIn(min = 100.dp)
        ) {
            description = it
        }

        Button(
            onClick = {},
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
                InsertProductScreen()
            }
        }
    }
}
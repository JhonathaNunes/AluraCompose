package com.nunes.jhonatha.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nunes.jhonatha.aluvery.R

@Composable
fun SearchTextField(
    searchText: String,
    modifier: Modifier = Modifier,
    onSearchChange: (String) -> Unit
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = onSearchChange,
        modifier
            .padding(
                16.dp
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(100),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Ícone de lupa")
        },
        label = {
            Text(stringResource(R.string.product))
        },
        placeholder = {
            Text(stringResource(R.string.what_are_you_looking_for))
        }
    )

}
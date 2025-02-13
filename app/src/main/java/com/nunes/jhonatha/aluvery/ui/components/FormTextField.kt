package com.nunes.jhonatha.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

@Composable
fun FormTextField(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value,
        onValueChange,
        modifier.fillMaxWidth(),
        label = {
            Text(label)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun FormTextFieldPreview() {
    AluveryTheme {
        FormTextField("", "Preview") { }
    }
}
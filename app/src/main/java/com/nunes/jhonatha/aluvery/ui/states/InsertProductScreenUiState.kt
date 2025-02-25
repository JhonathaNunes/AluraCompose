package com.nunes.jhonatha.aluvery.ui.states

class InsertProductScreenUiState(
    val url: String = "",
    val onUrlChange: (String) -> Unit = {},
    val name: String = "",
    val onNameChange: (String) -> Unit = {},
    val price: String = "",
    val onPriceChange: (String) -> Unit = {},
    val description: String = "",
    val onDescriptionChange: (String) -> Unit = {}
) {
    fun isUrlFilled() = url.isNotBlank()
}
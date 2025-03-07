package com.nunes.jhonatha.aluvery.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toBrazilianCurrencyFormat(): String {
    return NumberFormat.getCurrencyInstance(
        Locale(
            "pt",
            "br"
        )
    ).format(this)
}
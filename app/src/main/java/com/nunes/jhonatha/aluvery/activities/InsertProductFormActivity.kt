package com.nunes.jhonatha.aluvery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.nunes.jhonatha.aluvery.activities.ui.theme.AluveryTheme
import com.nunes.jhonatha.aluvery.dao.ProductDAO
import com.nunes.jhonatha.aluvery.ui.screens.InsertProductScreen

class InsertProductFormActivity : ComponentActivity() {

    private val productDAO = ProductDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(Modifier.padding(innerPadding)) {
                        InsertProductScreen(onSave = { product ->
                            productDAO.save(product)
                            finish()
                        })
                    }
                }
            }
        }
    }
}
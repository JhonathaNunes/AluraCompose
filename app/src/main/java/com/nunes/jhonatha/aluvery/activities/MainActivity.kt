package com.nunes.jhonatha.aluvery.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nunes.jhonatha.aluvery.dao.ProductDAO
import com.nunes.jhonatha.aluvery.sampledata.sampleSections
import com.nunes.jhonatha.aluvery.ui.screens.home.HomeScreen
import com.nunes.jhonatha.aluvery.ui.screens.home.HomeScreenUiState
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val productDAO = ProductDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(onFloatingButtonClick = {
                startActivity(
                    Intent(
                        this, InsertProductFormActivity::class.java
                    )
                )
            }) {
                val products = productDAO.products()

                HomeScreen(
                    products = products
                )
            }
        }
    }
}

@Composable
fun App(
    onFloatingButtonClick: () -> Unit = {}, content: @Composable () -> Unit = {}
) {
    AluveryTheme {
        Scaffold(floatingActionButton = {
            FloatingActionButton(
                onClick = onFloatingButtonClick
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Ícone adição")
            }
        }) { innerPadding ->
            Surface(Modifier.padding(innerPadding)) {
                content()
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun AppPreview() {
    AluveryTheme {
        App {
            HomeScreen(state = HomeScreenUiState(sections = sampleSections))
        }
    }
}

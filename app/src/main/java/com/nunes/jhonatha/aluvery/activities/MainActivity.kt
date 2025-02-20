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
import com.nunes.jhonatha.aluvery.sampledata.sampleSections
import com.nunes.jhonatha.aluvery.ui.screens.HomeScreen
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App {
                startActivity(Intent(
                    this,
                    InsertProductFormActivity::class.java
                ))
            }
        }
    }
}

@Composable
fun App(
    onFloatingButtonClick: () -> Unit
) {
    AluveryTheme {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onFloatingButtonClick
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Ícone adição")
                }
            }
        ) { innerPadding ->
            Surface(Modifier.padding(innerPadding)) {
                HomeScreen(sampleSections)
//            AllProductsScreen(sampleProducts)
            }
        }

    }
}

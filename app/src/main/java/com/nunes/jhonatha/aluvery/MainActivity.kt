package com.nunes.jhonatha.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.nunes.jhonatha.aluvery.sampledata.sampleProducts
import com.nunes.jhonatha.aluvery.sampledata.sampleSections
import com.nunes.jhonatha.aluvery.ui.screens.AllProductsScreen
import com.nunes.jhonatha.aluvery.ui.screens.HomeScreen
import com.nunes.jhonatha.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
//            AllProductsScreen(sampleProducts)
        }
    }
}

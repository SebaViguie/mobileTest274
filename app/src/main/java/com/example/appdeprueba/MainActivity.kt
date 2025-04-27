package com.example.appdeprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdeprueba.ui.theme.AppDePruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppDePruebaTheme {
                val navController = rememberNavController()
                val listaDeNotas = remember { mutableStateListOf<Nota>() }

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable(route = "inicio") {
                        Greeting(modifier = Modifier, navController)
                    }

                    composable(route = "ingreso") {
                        Ingreso(navController, listaDeNotas)
                    }
                }
            }
        }
    }
}

package com.example.appdeprueba

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appdeprueba.ui.theme.AppDePruebaTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(navController: NavController, listaDeNotas: List<Nota>) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de notas", style = MaterialTheme.typography.headlineLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(route = "ingreso")},
                containerColor = MaterialTheme.colorScheme.background
            )
            {
                Icon(Icons.Default.Create,
                    contentDescription = "Agregar")
            }
        },
        content = {paddingValues ->
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer),
                contentPadding = paddingValues)
            {
                items(listaDeNotas)
                {
                    nota ->
                        ElevatedCard(modifier = Modifier
                            .fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            shape = MaterialTheme.shapes.medium
                            )
                        {
                            Column(modifier = Modifier.padding(16.dp))
                            {
                                Text(text = nota.titulo, style = MaterialTheme.typography.titleLarge)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = nota.descripcion, style = MaterialTheme.typography.bodyLarge)
                                Spacer(modifier = Modifier
                                    .height(24.dp)
                                    .background(MaterialTheme.colorScheme.background))
                            }
                        }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppDePruebaTheme {
        Greeting(navController = rememberNavController(), listOf())
    }
}
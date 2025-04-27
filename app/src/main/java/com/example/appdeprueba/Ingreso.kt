package com.example.appdeprueba

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appdeprueba.ui.theme.AppDePruebaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ingreso(navController: NavController, listaDeNotas: SnapshotStateList<Nota>) {

    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {Text(text = "Agregar nota", style = MaterialTheme.typography.headlineLarge)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = {paddingValues ->
            LazyColumn(modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize(),
                contentPadding = paddingValues,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                item { Spacer(modifier = Modifier.height(24.dp)) }

                item { OutlinedTextField(
                    value = titulo,
                    onValueChange = {titulo = it},
                    label = { Text(text = "Título") }
                ) }

                item { Spacer(modifier = Modifier.height(16.dp)) }

                item { OutlinedTextField(
                    value = descripcion,
                    onValueChange = {descripcion = it},
                    label = { Text(text = "Descripción") }
                ) }

                item { Spacer(modifier = Modifier.height(16.dp)) }

                item { Button(onClick = {
                    val nota = Nota(titulo = titulo, descripcion = descripcion)
                    listaDeNotas.add(nota)
                    navController.popBackStack()
                })
                { Text(text = "Crear nota") }}
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun IngresoPreview() {
    AppDePruebaTheme {
        Ingreso(navController = rememberNavController(), listaDeNotas = SnapshotStateList())
    }
}

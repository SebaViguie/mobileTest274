package com.example.appdeprueba

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appdeprueba.ui.theme.AppDePruebaTheme


@Composable
fun Greeting(modifier : Modifier = Modifier, navController: NavController) {

    var textoPrimerInput by remember { mutableStateOf(value = "") }
    var textoSegundoInput by remember { mutableStateOf(value = "") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hola Laikaa",
            style = MaterialTheme.typography.titleLarge
        )

        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            Text(text = "Ingresa tu cuenta")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Cambiar usuario")
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textoPrimerInput,
            label = {Text(text = "Usuario")},
            onValueChange = {textoInput ->
                textoPrimerInput = textoInput
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textoSegundoInput,
            label = { Text(text = "Contraseña") },
            onValueChange = {textoInput ->
                textoSegundoInput = textoInput
            }
        )

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {navController.navigate(route = "ingreso")}
        ) {
            Text(text = "Ingresar")
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Olvide mi clave")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppDePruebaTheme {
        Greeting(navController = rememberNavController())
    }
}
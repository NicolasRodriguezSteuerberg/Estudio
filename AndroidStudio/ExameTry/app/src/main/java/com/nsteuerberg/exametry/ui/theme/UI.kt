package com.nsteuerberg.exametry.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nsteuerberg.exametry.R

@Composable
fun my_interface(miViewModel: MyViewModel){
    Column {
        start()
        numeros(miViewModel)
        textoRellenar(miViewModel)
    }
}

@Composable
fun start(){
    Row(modifier = Modifier.padding(15.dp,10.dp)){
        Text(text = "Inicio")
    }
    Row (modifier = Modifier.padding(15.dp,10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.church),
            contentDescription = R.string.descriptionChurch.toString()
        )
    }
}

@Composable
fun numeros(miViewModel: MyViewModel){
    Row {
        Text(
            text = "Lista de números:",
            modifier = Modifier.padding(15.dp, 0.dp)
        )
    }
    Row {
        Text(
            text = " ${miViewModel.getLista()}",
            modifier = Modifier.padding(15.dp, 0.dp)
        )
    }
    Row (modifier = Modifier.padding(0.dp, 5.dp)){
        Button(
            onClick = {
                miViewModel.generarNumeros()
            },
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(15.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mas),
                contentDescription = R.string.descriptionMas.toString()
            )
            Text(
                text = "Click for a random number",
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textoRellenar(miViewModel: MyViewModel){
    Row (modifier = Modifier.padding(10.dp,10.dp)) {
        OutlinedTextField(
            value = miViewModel.getName(),
            onValueChange = {
                miViewModel.myName.value = it
            },
            label = { Text(
                text = "Introduzca tu nombre",
                color = Color.Black
            )
            }
        )
    }
    Row (modifier = Modifier.padding(10.dp,10.dp)){
        if (miViewModel.getName().length > 3){
            Text(
                text = "Hola: ${miViewModel.getName()}"
            )
        }
    }
}
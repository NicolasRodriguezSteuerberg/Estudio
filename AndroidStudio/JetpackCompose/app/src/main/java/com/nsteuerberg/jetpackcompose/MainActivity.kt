package com.nsteuerberg.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nsteuerberg.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android")
                    state()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row (
        // te centra la fila verticalmente
        verticalAlignment = Alignment.CenterVertically,
        //te lo mueve horizontalmente
        horizontalArrangement = Arrangement.Center
        // Si fuese una columna el alignement sería el horizontal y el arrangement el vertical
    ){
        Surface(
            color = Color.Green,
            // si no le pones nada en los paréntesis se pone en el centro, el wrapContent coge el tamaño que tenga su hijo
            modifier = Modifier
                .wrapContentSize(Alignment.TopStart)
                .padding(10.dp)
        ){
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
        mySquare(miColor = Color.Green)
        mySquare(miColor = Color.Red)
    }
}
@Composable
fun state(){
    val students = remember{ mutableStateListOf("Miguel", "Esther") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        for (student in students){
            Text(text = student)
        }
        Button(onClick = {
            students.add("Jaime")
        ¡}) {
            Text(text = "Añadir")
        }
    }
}

@Composable
fun mySquare(miColor: Color){
    Surface (
        color = miColor,
        modifier = Modifier.size(60.dp)
    ){

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        Greeting("Android")
    }
}
package com.nsteuerberg.ejerciciofuncionesclases

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nsteuerberg.ejerciciofuncionesclases.ui.theme.EjercicioFuncionesClasesTheme
val TAG = "Estado"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicioFuncionesClasesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val obxProgramador = Programador()

        obxProgramador.getProgrammerData()
    }

    class Programador: ProgramadorInterface{

        override fun getProgrammerData(): ProgrammerData = ProgrammerData(getName(), getAge(), getLanguaje())

        private fun getName(): String{
            return "Rodrigo"
        }

        private fun getAge(): Int{
            return 2023 - 2003
        }

        private fun getLanguaje(): String = "Kotlin"
        }
    }

    interface ProgramadorInterface{
        fun getProgrammerData(): ProgrammerData
    }

    data class ProgrammerData(
        val name: String,
        val age: Int,
        val language: String
    )


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioFuncionesClasesTheme {
        Greeting("Android")
    }
}
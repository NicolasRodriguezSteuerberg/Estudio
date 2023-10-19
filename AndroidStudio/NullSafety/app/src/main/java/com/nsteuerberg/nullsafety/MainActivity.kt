package com.nsteuerberg.nullsafety

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
import com.nsteuerberg.nullsafety.ui.theme.NullSafetyTheme

val TAG = "Ejecucion"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NullSafetyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        // nullSafety()
        funciones()
    }

    private fun nullSafety(){
        var nullString: String? = null

        nullString?.let {
            Log.d(TAG, nullString)
        } ?: run {
           // Log.d(TAG, nullString)
        }

    }

    private fun funciones(){
        var age: Int = returnAgeCompact(2003)
        printNameAge("Nico", age)
        age = returnAge(2002)
        printNameAge("JoseCarlos", age)
    }

    private fun printNameAge(name: String, age: Int){
        Log.d(TAG, "My name is $name")
        Log.d(TAG, "My age is $age")
    }

    private fun returnAge(birthYear: Int): Int{
        return 2023 - birthYear
    }
    // same function but in a compact formn
    private fun returnAgeCompact(birthYear: Int): Int = 2023 - birthYear

    private fun clases(){
        var dataRodrigo = PersonData("Rodrigo", 19)
        var obxP = Persona(dataRodrigo)
        var obxP2 = Persona(PersonData("Raquel", 20))

        obxP.presentacion()
        obxP2.presentacion()
    }

    class Persona(private val data: PersonData){
        fun presentacion(){
            Log.d(TAG,"My name is ${data.name} and my age is ${data.age}")

        }
    }

    // clase que simplemente almacena datos
    data class PersonData(
        val name: String?,
        val age: Int?
    )

    private fun interfaces(){
        var dataRodrigo = PersonData("Rodrigo", 19)
        var rodrigo = SegundaPersona(dataRodrigo)

        //rodrigo.presentacion()
        val edad = rodrigo.returnAge(2003)
        Log.d(TAG, "My name is $edad")
    }

    class SegundaPersona(private val data: PersonData): PersonInterface{
        fun presentacion(){
            Log.d(TAG,"My name is ${data.name} and my age is ${data.age}")
        }

        override fun returnAge(birthYear: Int): Int = 2023 - birthYear
    }

    interface PersonInterface{
        fun returnAge(birthYear: Int): Int
    }

}



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
    NullSafetyTheme {
        Greeting("Android")
    }
}
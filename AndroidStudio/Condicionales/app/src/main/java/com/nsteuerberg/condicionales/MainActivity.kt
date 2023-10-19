package com.nsteuerberg.condicionales

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
import com.nsteuerberg.condicionales.ui.theme.CondicionalesTheme
val TAG: String = "Estado"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CondicionalesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        condicionales()
        listas()
    }
}

fun condicionales(){
    // condicion sobre una variable
    val booleanValue: Boolean = true
    val edad: Int = if (!booleanValue){
        17 // si es booleanValue es falso
    }else {
        26 //si es true
    }

    // switch
    fun condicionalesWhen(){
        val language: String = "Kotlin"
        when (language){
            "Kotlin", "Scala" -> {
                Log.d(TAG,"se ha seleccionado kotlin")
            }
            "Java" -> Log.d(TAG,"se ha seleccionado java")
            "Python" -> Log.d(TAG,"se ha seleccionado python")
        }

        val myNumber: Int = 94
        when (myNumber){
            in 0..10 -> {
                Log.d(TAG,"se ha seleccionado kotlin")
            }
            11 -> Log.d(TAG,"se ha seleccionado java")
        }
    }
}
fun listas(){
    val list = listOf<String>()
    val list2: List<String> = listOf()

    val arrayList = arrayListOf<String>()
    val arrayList2: ArrayList<String> = arrayListOf()

    // es innecesario porner <String>
    val myList = listOf("Rodrigo", "Raquel", "David")
    val myArrayList = arrayListOf("Rodrigo", "Raquel", "David")

    val listItem = myList[2]
    val arrayListItem = myList[1]
    // myList[2] = "Sandra" // no puedes cambiarlo
    myArrayList[2] = "Sandra"

    myArrayList.remove("Sandra")
    myArrayList.removeAt(2)

    myArrayList.clear() // vacia el arrayList
    myArrayList.addAll(myList) // añade todos los elementos de la lista al arrayList

    // si el arrayList fuera sobre objetos podemos ordenarlos por una variable de ellos
    //myArrayList.sortByDescending { nombre }

    Log.d(TAG, myArrayList.toString())

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
    CondicionalesTheme {
        Greeting("Android")
    }
}
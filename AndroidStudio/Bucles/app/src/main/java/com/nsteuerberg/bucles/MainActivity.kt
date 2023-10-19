package com.nsteuerberg.bucles

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
import com.nsteuerberg.bucles.ui.theme.BuclesTheme
val TAG: String = "Estado"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuclesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        //bucleFor()
        //bucleWhile()
        bucleDoWhile()
    }

    private fun bucleFor(){
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "David")

        for (persona in myArrayList){
            Log.d(TAG, persona)
        }

        for(position in 0..10){
            Log.d(TAG, position.toString())
        }

        for(position in 0 until 10){
            Log.d(TAG, position.toString())
        }

        //saltando posiciones
        for(position in 0..10 step 2){
            Log.d(TAG, position.toString())
        }

        // va de diez hasta 3
        for(position in 10 downTo 3){
            Log.d(TAG, position.toString())
        }

        for (position in 0 until myArrayList.size){
            Log.d(TAG, myArrayList[position].toString())
        }
    }

    private fun bucleWhile(){
        var myNumber: Int = 10

        while (myNumber < 20){
            Log.d(TAG, myNumber.toString())
            myNumber ++
        }
    }

    private fun bucleDoWhile(){
        var myNumber: Int = 10

        do{
            Log.d(TAG, myNumber.toString())
            myNumber ++
        }while (myNumber < 20)
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
    BuclesTheme {
        Greeting("Android")
    }
}
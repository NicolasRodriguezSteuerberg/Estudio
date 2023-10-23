package com.nsteuerberg.exametry.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel() {
    private val LOG_TAG: String = "Estado"
    var numero: Int = 0
    val myList = mutableStateListOf<Int>()
    val myName = mutableStateOf("")

    init {
        Log.d(LOG_TAG, "Inicializamos ViewModel")
    }

    fun generarNumeros(){
        numero = (0..10).random()
        myList.add(numero)
        Log.d(LOG_TAG, numero.toString())
    }

    fun getLista(): List<Int>{
        return myList.toList()
    }

    fun getName(): String{
        return myName.value
    }
}
package com.nsteuerberg.exametry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nsteuerberg.exametry.ui.theme.ExameTryTheme
import com.nsteuerberg.exametry.ui.theme.MyViewModel
import com.nsteuerberg.exametry.ui.theme.my_interface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val miViewModel: MyViewModel = MyViewModel()
        setContent {
            ExameTryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                ) {
                    my_interface(miViewModel)
                }
            }
        }
    }
}

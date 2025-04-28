package com.example.poc

import Navegation.AppNavigation
import login.ui.LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.poc.ui.theme.POCTheme
import login.ui.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            POCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->

AppNavigation()
                }
            }
        }
    }
}
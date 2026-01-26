package com.example.androidlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidlab.ui.Home
import com.example.androidlab.ui.PokemonList
import com.example.androidlab.ui.theme.AndroidLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidLabTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Home(navController = navController)
                    }
                    composable("pokemons") {
                        PokemonList(navController = navController)
                    }
                }
            }
        }
    }
}
package com.example.androidlab.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidlab.Repository.PokemonRepository

@Composable
fun PokemonList(navController: NavHostController) {
    val pokemons = PokemonRepository().getPokemons()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(pokemons) { pokemon ->
                PokemonCard(pokemon)
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { navController.navigateUp() }) {
                    Text(text = "Retour")
                }
            }
        }
    }
}
package com.example.recipeapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeapp.viewmodel.Recipe

@Composable
fun HomeScreen(
    recipes: List<Recipe>,
    onRecipeClick: (Int) -> Unit,
    onFavoritesClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Recipes") }, actions = {
                TextButton(onClick = onFavoritesClick) {
                    Text("Favorites")
                }
            })
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(recipes.size) { index ->
                val recipe = recipes[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onRecipeClick(recipe.id) }
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(recipe.title, style = MaterialTheme.typography.titleMedium)
                        Text("${recipe.ingredients.size} ingredients", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

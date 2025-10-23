package com.example.recipeapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeapp.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    favoriteRecipes: List<Recipe>,
    onRecipeClick: (Int) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorites") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (favoriteRecipes.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("No favorites yet.")
            }
        } else {
            LazyColumn(contentPadding = padding) {
                items(favoriteRecipes.size) { index ->
                    val recipe = favoriteRecipes[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { onRecipeClick(recipe.id) }
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(recipe.title, style = MaterialTheme.typography.titleMedium)
                            Text("${recipe.ingredients.size} ingredients")
                        }
                    }
                }
            }
        }
    }
}

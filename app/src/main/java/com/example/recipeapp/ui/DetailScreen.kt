package com.example.recipeapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder

import com.example.recipeapp.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    recipe: Recipe,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(recipe.title) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Back") }
                },
                actions = {
                    IconButton(onClick = onToggleFavorite) {
                        Icon(
                            if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Ingredients:", style = MaterialTheme.typography.titleMedium)
            recipe.ingredients.forEach { Text("• $it") }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Steps:", style = MaterialTheme.typography.titleMedium)
            recipe.steps.forEachIndexed { i, step ->
                Text("${i + 1}. $step")
            }
        }
    }
}

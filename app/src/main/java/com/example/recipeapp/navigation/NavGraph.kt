package com.example.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipeapp.ui.HomeScreen
import com.example.recipeapp.ui.DetailScreen
import com.example.recipeapp.viewmodel.RecipeViewModel
import com.example.recipeapp.ui.FavoritesScreen


@Composable
fun NavGraph(navController: NavHostController, recipeViewModel: RecipeViewModel) {
    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            val recipes by recipeViewModel.recipes.collectAsState()
            HomeScreen(
                recipes = recipes,
                onRecipeClick = { id -> navController.navigate("details/$id") },
                onFavoritesClick = { navController.navigate("favorites") }
            )
        }

        composable("details/{recipeId}") { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull() ?: -1
            val recipe = recipeViewModel.getRecipeById(recipeId)

            if (recipe != null) {
                DetailScreen(
                    recipe = recipe,
                    isFavorite = recipeViewModel.isFavorite(recipe.id), // Assuming you have this logic
                    onToggleFavorite = { recipeViewModel.toggleFavorite(recipe.id) }, // Assuming you have this
                    onBack = { navController.popBackStack() }
                )
            } else {
                navController.popBackStack()
            }
        }

        composable("favorites") {
            val favoriteRecipes by recipeViewModel.favoriteRecipes.collectAsState() // Assuming favorites are also a StateFlow
            FavoritesScreen(
                favoriteRecipes = favoriteRecipes,
                onRecipeClick = { id -> navController.navigate("details/$id") },
                onBack = { navController.popBackStack() }
            )
        }
    }
}

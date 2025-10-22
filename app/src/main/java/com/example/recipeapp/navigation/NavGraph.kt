package com.example.recipesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipeapp.ui.DetailScreen
import com.example.recipeapp.ui.FavoritesScreen
import com.example.recipeapp.ui.HomeScreen
import com.example.recipesapp.ui.*
import com.example.recipesapp.viewmodel.RecipeViewModel

@Composable
fun NavGraph(navController: NavHostController, recipeViewModel: RecipeViewModel) {
    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                recipes = recipeViewModel.recipes,
                onRecipeClick = { id -> navController.navigate("details/$id") },
                onFavoritesClick = { navController.navigate("favorites") }
            )
        }

        composable("details/{recipeId}") { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toInt() ?: 0
            val recipe = recipeViewModel.getRecipeById(recipeId)
            recipe?.let {
                DetailScreen(
                    recipe = it,
                    isFavorite = recipeViewModel.isFavorite(it.id),
                    onToggleFavorite = { recipeViewModel.toggleFavorite(it.id) },
                    onBack = { navController.popBackStack() }
                )
            }
        }

        composable("favorites") {
            FavoritesScreen(
                favoriteRecipes = recipeViewModel.favoriteRecipes,
                onRecipeClick = { id -> navController.navigate("details/$id") },
                onBack = { navController.popBackStack() }
            )
        }
    }
}

package com.example.recipeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipeapp.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes.asStateFlow()

    private val _favoriteRecipes = MutableStateFlow<List<Recipe>>(emptyList())
    val favoriteRecipes: StateFlow<List<Recipe>> = _favoriteRecipes.asStateFlow()

    init {
        _recipes.value = loadRecipes()
    }

    private fun loadRecipes(): List<Recipe> {
        return listOf(
            Recipe(1, "Classic Pancakes", listOf("Flour", "Milk", "Egg", "Sugar"), listOf("Mix all ingredients.", "Pour onto hot griddle.")),
            Recipe(2, "Spaghetti Bolognese", listOf("Pasta", "Ground Beef", "Tomato Sauce"), listOf("Cook pasta.", "Cook beef and add sauce.", "Serve together."))
        )
    }

    fun getRecipeById(id: Int): Recipe? {
        return _recipes.value.find { it.id == id }
    }

    fun isFavorite(id: Int): Boolean {
        return _favoriteRecipes.value.any { it.id == id }
    }

    fun toggleFavorite(id: Int) {
        val recipe = getRecipeById(id) ?: return

        if (isFavorite(id)) {
            _favoriteRecipes.update { currentFavorites ->
                currentFavorites.filterNot { it.id == id }
            }
        } else {
            _favoriteRecipes.update { currentFavorites ->
                currentFavorites + recipe
            }
        }
    }
}

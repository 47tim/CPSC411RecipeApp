package com.example.recipeapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Recipe(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val steps: List<String>
)

class RecipeViewModel : ViewModel() {

    // Hardcoded data
    val recipes = listOf(
        Recipe(1, "Spaghetti Carbonara", listOf("Spaghetti", "Eggs", "Pancetta", "Parmesan"), listOf("Boil pasta", "Cook pancetta", "Mix with eggs & cheese")),
        Recipe(2, "Pancakes", listOf("Flour", "Milk", "Eggs", "Sugar"), listOf("Mix ingredients", "Pour on pan", "Flip when golden")),
        Recipe(3, "Guacamole", listOf("Avocado", "Onion", "Lime", "Salt"), listOf("Mash avocado", "Add chopped onion", "Season to taste"))
    )

    // Favorite state
    private val _favoriteIds = mutableStateListOf<Int>()
    val favoriteRecipes: List<Recipe>
        get() = recipes.filter { it.id in _favoriteIds }

    fun toggleFavorite(id: Int) {
        if (_favoriteIds.contains(id)) _favoriteIds.remove(id)
        else _favoriteIds.add(id)
    }

    fun isFavorite(id: Int): Boolean = _favoriteIds.contains(id)

    fun getRecipeById(id: Int): Recipe? = recipes.find { it.id == id }
}

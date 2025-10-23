package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.viewmodel.RecipeViewModel
import com.example.recipeapp.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val recipeViewModel: RecipeViewModel = viewModel()

            Surface(color = MaterialTheme.colorScheme.background) {
                NavGraph(navController = navController, recipeViewModel = recipeViewModel)
            }
        }
    }
}

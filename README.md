# CPSC411RecipeApp

## Team Members: 
* Jorge Patino, jorgep945@csu.fullerton.edu, 884533514
* Adam Cha, adamcha1@csu.fullerton.edu, 887723245
* Keigo Noguchi, keigo.noguchi@csu.fullerton.edu, 885486746
* Timothy Hyde, hydet47@csu.fullerton.edu, 884583832

# Project Description 

1. Home Screen
* Each recipe shows its title and the number of ingredients.
* Users can click a recipe to view its detailed information.
* Includes a Favorites button in the top app bar to navigate to the Favorites screen.

2. Detail Screen
* Shows detailed information for the selected recipe:
List of ingredients.
Step-by-step preparation instructions.
* Users can toggle a recipe as a favorite using a heart icon.
* Includes a back navigation button to return to the previous screen.

3. Favorites Screen
* Displays a list of recipes marked as favorites.
* Clicking a recipe navigates to its Detail screen.
* Shows a message when no favorites have been added.
* Provides a back button to return to the Home screen.

## State Management:
The app uses StateFlow to manage UI updates for recipes and favorites. The HomeScreen and FavoritesScreen automatically update when data changes.

## ViewModel:
RecipeViewModel stores all recipes and favorite recipes, providing methods to toggle favorites and retrieve recipes by ID.

## Navigation:
Implemented using Jetpack Compose Navigation, allowing seamless transitions between Home, Detail, and Favorites screens.

## Data:
Recipes are hardcoded as a list in RecipeViewModel for testing.

## UI:
Clean and minimal interface with Material Design components including the TopAppBar, Card, and LazyColumn.

## Meeting the Expected Deliverables
1. Working multi-screen app with at least three screens (Home, Detail, Favorites).
2. Proper use of ViewModel and State to handle UI updates.
3. Navigation implementation for screen transitions.
4. Hardcoded recipe data in the app (no backend required).
5. Clean UI and meaningful user interaction with favorite toggling.

Screenshots:

<img width="233" height="514" alt="Screenshot 2025-10-22 at 8 10 58 PM" src="https://github.com/user-attachments/assets/262bb3d1-484d-44d6-b102-56e614816a7b" />
<img width="239" height="514" alt="Screenshot 2025-10-22 at 8 11 09 PM" src="https://github.com/user-attachments/assets/1b905f14-7348-4ea5-a972-bcaee81c676e" />
<img width="235" height="513" alt="Screenshot 2025-10-22 at 8 11 44 PM" src="https://github.com/user-attachments/assets/a9e4dc15-f16f-44d5-9b76-d5bd9d85b94c" />

Hard coded data:

<img width="1083" height="142" alt="Screenshot 2025-10-22 at 8 13 07 PM" src="https://github.com/user-attachments/assets/20fea22b-5d07-4151-bd7a-4e41a7309d3a" />

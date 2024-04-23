package com.nbscvincent.csc4222024midterm.data.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscvincent.csc4222024midterm.data.recipes.viewmodel.RecipeViewModel

@Composable
fun RecipeScreen(
    navController: NavController,
    recipesViewModel: RecipeViewModel
) {
    val recipeList = recipesViewModel.recipeList

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Recipes",
                fontSize = 45.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        LazyColumn (modifier = Modifier
            .padding(24.dp)
        ) {
            items(recipeList) { recipe ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(text = "Name: ${recipe.name}")
                        Text(text = "Ingredients: ${recipe.ingredients.joinToString(", ")}")
                        Text(text = "Instructions: ${recipe.instructions.joinToString(", ")}")
                        Text(text = "Prep Time: ${recipe.prepTimeMinutes} minutes")
                    }
                }
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier
                .width(300.dp)
                .padding(bottom = 50.dp)
                .align(Alignment.BottomCenter)
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }
    }

    LaunchedEffect(true) {
        recipesViewModel.getRecipes()
    }
}
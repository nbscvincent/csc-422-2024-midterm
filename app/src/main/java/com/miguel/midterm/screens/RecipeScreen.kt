package com.miguel.midterm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.miguel.midterm.AppViewModelProvider
import com.miguel.midterm.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(
    navController: NavController,
    recipesViewModel: RecipeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val recipeList = recipesViewModel.recipeList


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Text(
                            text = "Recipes",
                            fontWeight = FontWeight.Bold,
                            fontSize = 45.sp,
                            modifier = Modifier,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Red
                        )
                    }
                },

                )

        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier
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
                            Text(text = "Name: ${recipe.name}", fontWeight = FontWeight.Bold )
                            Text(text = "Ingredients: ${recipe.ingredients.joinToString(", ")}", fontWeight = FontWeight.Bold)
                            Text(text = "Instructions: ${recipe.instructions.joinToString(", ")}", fontWeight = FontWeight.Bold)
                            Text(text = "Prep Time: ${recipe.prepTimeMinutes} minutes", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

        }
        LaunchedEffect(true) {
            recipesViewModel.getRecipes()
        }
    }
}
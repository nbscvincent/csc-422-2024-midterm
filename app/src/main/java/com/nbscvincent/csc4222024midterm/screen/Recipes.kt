package com.nbscvincent.csc4222024midterm.screen

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.work.WorkManager
import com.nbscvincent.csc4222024midterm.data.AppViewModelProvider
import com.nbscvincent.csc4222024midterm.navigation.routes.MainScreen
import com.nbscvincent.csc4222024midterm.preferences.PreferencesManager
import com.nbscvincent.csc4222024midterm.viewmodel.LoginScreenViewModel
import com.nbscvincent.csc4222024midterm.viewmodel.RecipeViewModel
import com.nbscvincent.csc4222024midterm.viewmodel.ScreenViewModel
import com.nbscvincent.csc4222024midterm.viewmodel.ToDoViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipes(
    navController: NavController,
    screenViewModel: ScreenViewModel
) {
    val viewModel: RecipeViewModel = viewModel(factory = AppViewModelProvider.Factory)


    val coroutineScope = rememberCoroutineScope()

    val recipesState = viewModel.recipesUiState

    val todo by remember { mutableStateOf("") }


   

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Button(
                        onClick = {
                            navController.navigate(MainScreen.HomePage.name)
                        }
                    ) {
                        Text("Back")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Gray),
                actions = {

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Gray,
            ) {

                Button(onClick = {

                    screenViewModel.unsetLogin()
                    navController.navigate(MainScreen.Splash.name)

                }) {
                    Text("SignOut")
                }
            }

        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))


            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.getRecipes()
                    }
                },

                ) {
                Text("Get Recipes")
            }

            val recipeList = recipesState.recipes
                .split(",")
                .map { it.replace("[\\[\\]\"{}]".toRegex(), "") } // Remove unwanted characters

            LazyColumn {
                items(recipeList) { recipes ->

                    Text(recipes, color = Color.Black)
                    Spacer(modifier = Modifier.height(10.dp))

                }
            }








        }









    }
}

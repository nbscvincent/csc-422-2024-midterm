package com.nbscvincent.csc4222024midterm.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.nbscvincent.csc4222024midterm.NavHost.Route
import com.nbscvincent.csc4222024midterm.model.AppScreenViewModel
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel
import kotlinx.coroutines.launch
import java.io.File


@Composable
fun Recipes(
    navController: NavHostController,
    screenViewModel: ScreenViewModel,
) {
    val coroutineScope = rememberCoroutineScope()
    val homeModel = viewModel<AppScreenViewModel>()

    LaunchedEffect(key1 = true) {
        homeModel.getRecipes()
    }

    if (homeModel.recipesList.isEmpty()) {
        Scaffold { innerPadding ->
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
                Text(
                    text = "Please wait....",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black,
                )
            }
        }
    } else {

        Scaffold { innerPadding ->
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
                Text(
                    text = "Recipes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(Route.HomePage.name)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF783137)
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        text = "Home",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                LazyColumn {
                    itemsIndexed(homeModel.recipesList) { index, item ->

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 25.dp,
                                    end = 25.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                )

                        )
                        {

                            Text(
                                text = item.name,
                                color = Color.Blue,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = "Ingredients:",
                                color = Color.Red
                            )
                            Text(
                                text = item.ingredients.toString(),
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                text = "Instructions",
                                color = Color.Red
                            )
                            Text(
                                text = item.instructions.toString(),
                                fontWeight = FontWeight.SemiBold
                            )

                            Row {
                                Text(text = "Preparation Time Minutes: ")
                                Text(text = item.prepTimeMinutes.toString())
                            }
                            Row {
                                Text(text = "Cooking Time Minutes: ")
                                Text(text = item.cookTimeMinutes.toString())
                            }
                            Row {
                                Text(text = "Servings: ")
                                Text(text = item.servings.toString())
                            }
                            Row {
                                Text(text = "Difficulty: ")
                                Text(
                                    text = item.difficulty,
                                    color = Color.Black,
                                )
                            }
                            Row {
                                Text(text = "Cuisine: ")
                                Text(
                                    text = item.cuisine,
                                    color = Color.Black,
                                )
                            }
                            Row {
                                Text(text = "Calories Per Serving: ")
                                Text(
                                    text = item.caloriesPerServing.toString(),
                                    color = Color.Black,
                                )
                            }
                            Row {
                                Text(text = "Tags: ")
                                Text(text = item.tags.toString())
                            }
                            Row {
                                Text(text = "User ID: ")
                                Text(text = item.userId.toString())
                            }
                            Row {
                                Text(text = "Rating: ")
                                Text(
                                    text = item.rating,
                                    color = Color.Black,
                                )
                            }
                            Row {
                                Text(text = "Review Count: ")
                                Text(text = item.reviewCount.toString())
                            }
                            Row {
                                Text(text = "Meal type: ")
                                Text(text = item.mealType.toString())
                            }
                            Row {
                                Text(text = item.image.toString())
                            }

                            Text(
                                text = "=================================="
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}




package com.nbscvincent.csc4222024midterm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import com.nbscvincent.csc4222024midterm.model.AppScreenViewModel
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel
import kotlinx.coroutines.launch

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

    if (homeModel.recipesList.isEmpty()){
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
                    text = "Loading... Please wait....",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black,
                )
            }
        }
    }else {

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
                            navController.navigate(MainNav.HomePage.name)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5742f5)
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        text = "Back",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn {
                    itemsIndexed(homeModel.recipesList) { index, item ->

                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp, end = 25.dp, top = 1.dp, bottom = 5.dp),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 25.dp,
                                        end = 25.dp,
                                        top = 10.dp,
                                        bottom = 10.dp
                                    )
                            ) {
                                Text(
                                    text = item.name,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = item.difficulty,
                                    color = Color.Black,
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}
package com.nbscvincent.csc4222024midterm.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nbscvincent.csc4222024midterm.navigation.routes.MainScreen
import com.nbscvincent.csc4222024midterm.viewmodel.ScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipes(
    navController: NavController,
    screenViewModel: ScreenViewModel
) {

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




        }









    }
}

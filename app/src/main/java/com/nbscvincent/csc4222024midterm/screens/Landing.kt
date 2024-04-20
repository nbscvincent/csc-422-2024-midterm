package com.nbscvincent.csc4222024midterm.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel

@Composable
fun Landing (
    navController: NavController,
    screenViewModel: ScreenViewModel
){
    navController.navigate(MainNav.CheckLogin.name)
}
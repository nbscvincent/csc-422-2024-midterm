package com.nbscvincent.csc4222024midterm.screens

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(
    screenViewModel: ScreenViewModel
){
    CheckLogin(screenViewModel)
    //Login(navController = navController, screenViewModel = screenViewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckLogin( screenViewModel: ScreenViewModel ){
    val navController: NavHostController = rememberNavController()
    if (screenViewModel.checkLogin()){
        MainLogin(navController, screenViewModel)
    }else{
        MainHomeScreen(navController, screenViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLogin(
    navController: NavHostController,
    screenViewModel: ScreenViewModel
){
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = MainNav.Login.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = MainNav.Login.name) {
                Login( navController, screenViewModel )
            }
            composable(route = MainNav.HomePage.name) {
                HomeScreen(navController, screenViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHomeScreen(
    navController: NavHostController,
    screenViewModel: ScreenViewModel
){
    Scaffold{
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = MainNav.HomePage.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = MainNav.Login.name) {
                Login( navController, screenViewModel )
            }
            composable(route = MainNav.HomePage.name) {
                HomeScreen(navController, screenViewModel)
            }
            composable(route = MainNav.Recipes.name) {
                Recipes(navController, screenViewModel)
            }
            composable(route = MainNav.Todos.name) {
                Todos(navController, screenViewModel)
            }
        }
    }
}